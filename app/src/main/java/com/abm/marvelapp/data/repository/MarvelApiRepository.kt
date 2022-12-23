package com.abm.marvelapp.data.repository


import com.abm.marvelapp.domain.model.CharactersDTO
import com.abm.marvelapp.domain.model.DataMarvelDTO
import com.abm.marvelapp.utils.ApiResponseStatus

interface MarvelApiRepository {
    suspend fun getCharactersApi() : ApiResponseStatus<CharactersDTO>

}