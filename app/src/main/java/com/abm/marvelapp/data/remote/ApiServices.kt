package com.abm.marvelapp.data.remote

import com.abm.marvelapp.domain.model.CharactersDTO
import com.abm.marvelapp.domain.model.dtomarvel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("characters?")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Response<List<CharactersDTO>>

}