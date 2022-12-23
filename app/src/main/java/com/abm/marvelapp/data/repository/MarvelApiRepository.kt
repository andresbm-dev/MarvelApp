package com.abm.marvelapp.data.repository

import com.abm.marvelapp.domain.model.CharactersDTO

interface MarvelApiRepository {
    suspend fun getCharactersApi() : List<CharactersDTO>

}