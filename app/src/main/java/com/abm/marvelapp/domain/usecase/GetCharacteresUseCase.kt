package com.abm.marvelapp.domain.usecase

import com.abm.marvelapp.domain.model.CharactersDTO

interface GetCharacteresUseCase {
    suspend operator fun invoke(): List<CharactersDTO>
}