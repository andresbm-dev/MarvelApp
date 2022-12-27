package com.abm.marvelapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abm.marvelapp.data.local.HeroEntity
import com.abm.marvelapp.domain.model.CharactersDTO
import com.abm.marvelapp.domain.model.ResultsMarvel
import com.abm.marvelapp.domain.usecase.GetCharacteresLocalUseCase
import com.abm.marvelapp.domain.usecase.GetCharacteresUseCase
import com.abm.marvelapp.utils.ApiResponseStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.functions.Consumer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MarvelViewModelImp @Inject constructor(
    private val getCharactersUseCase: GetCharacteresUseCase,
   private val getCharacteresLocalUseCase: GetCharacteresLocalUseCase
): ViewModel(), MarvelViewModel {
    private val characters : MutableLiveData<List<ResultsMarvel>> = MutableLiveData()
    val charactersLiveData : LiveData<List<ResultsMarvel>> = characters

    private val charactersLocal : MutableLiveData<List<HeroEntity>> = MutableLiveData()
    val charactersLocalLiveData : LiveData<List<HeroEntity>> = charactersLocal

    private val error:MutableLiveData<Boolean> = MutableLiveData()
    val errorLiveData :LiveData<Boolean> = error
    override fun getCharacters() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getCharactersUseCase.invoke().subscribe(Consumer {
                    handleResponse(it)
                })
            }
        }

    }

    private fun handleResponse(apiResponseStatus: ApiResponseStatus<CharactersDTO>) {
        when(apiResponseStatus){
            is ApiResponseStatus.Success -> setResponse(apiResponseStatus.data)
            is ApiResponseStatus.Error -> setErrorResponse(apiResponseStatus.messageId)
            is ApiResponseStatus.Failure -> setDataBaseData()
            else -> {setErrorResponse("error")}
        }

    }

    private fun setDataBaseData() {
        Log.d("internte", "conexion")
    }

    private fun setErrorResponse(messageId: String) {
        Log.d("response api ", messageId)
        error.postValue(true)

    }

    private fun setResponse(data: CharactersDTO) {
        val listHeroes= mutableListOf<ResultsMarvel>()
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result: List<HeroEntity> = getCharacteresLocalUseCase.getHeroLocal()
                    if (result.isEmpty()){
                        data.data?.results?.forEach {
                            getCharacteresLocalUseCase.insertHeroeLocal(
                                HeroEntity(
                                    identifier = it.id,
                                    name = it.name,
                                    imageFlag = it.thumbnail?.path + '.' + it.thumbnail?.path
                                )
                            )
                        }
                        data.data?.results?.forEach{
                            listHeroes.add(it)
                        }
                        error.postValue(false)
                        characters.postValue(listHeroes)
                }else{
                    charactersLocal.postValue(result)
                }
            }
        }

    }
}