package com.abm.marvelapp.data.repository

import android.util.Log
import com.abm.marvelapp.API_KEY_PUBLIC
import com.abm.marvelapp.HASH
import com.abm.marvelapp.data.remote.ApiServices
import com.abm.marvelapp.domain.model.CharactersDTO
import com.abm.marvelapp.domain.model.DataMarvelDTO
import com.abm.marvelapp.utils.ApiResponseStatus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MarvelApiRepositoryImp @Inject constructor(
    private val apiServices: ApiServices
) : MarvelApiRepository {
    override suspend fun getCharactersApi(): ApiResponseStatus<CharactersDTO> = suspendCoroutine{
            val response = apiServices.getCharacters("1", API_KEY_PUBLIC, HASH)
            response.enqueue(object : Callback<CharactersDTO>{
                override fun onResponse(
                    call: Call<CharactersDTO>,
                    response: Response<CharactersDTO>
                ) {
                    val respons = response.body()
                    Log.d("api body", respons.toString())
                    it.resume(ApiResponseStatus.Success(response.body()!!))
                }

                override fun onFailure(call: Call<CharactersDTO>, t: Throwable) {
                    if (t.toString().contains("java.net.SocketTimeoutException:"))
                        it.resume(ApiResponseStatus.Failure(emptyList()))
                    else
                     it.resume(ApiResponseStatus.Error(t.toString()))
                }
            })
    }
}