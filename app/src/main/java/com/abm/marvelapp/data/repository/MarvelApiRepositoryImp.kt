package com.abm.marvelapp.data.repository

import com.abm.marvelapp.API_KEY_PUBLIC
import com.abm.marvelapp.HASH
import com.abm.marvelapp.data.remote.ApiServices
import com.abm.marvelapp.domain.model.CharactersDTO
import javax.inject.Inject

class MarvelApiRepositoryImp @Inject constructor(
    private val apiServices: ApiServices
) : MarvelApiRepository {
    override suspend fun getCharactersApi(): List<CharactersDTO> {
        return try {
            val response = apiServices.getCharacters("1", API_KEY_PUBLIC, HASH)
            val body =response.body()
            response.body() ?: emptyList()
        }catch (e :Exception){
            emptyList()
        }
    }

}