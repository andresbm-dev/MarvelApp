package com.abm.marvelapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abm.marvelapp.domain.usecase.GetCharacteresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MarvelViewModelImp @Inject constructor(
    private val getCharactersUseCase: GetCharacteresUseCase
): ViewModel(), MarvelViewModel {
    override fun getCharacters() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getCharactersUseCase.invoke()
            }
        }

    }


}