package com.abm.marvelapp.data.remote


import com.abm.marvelapp.domain.model.CharactersDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("characters?")
     fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Call<CharactersDTO>

}