package com.abm.marvelapp.domain.usecase

import com.abm.marvelapp.data.repository.MarvelApiRepositoryImp
import com.abm.marvelapp.domain.model.CharactersDTO
import javax.inject.Inject

class GetCharacteresUseCaseImp @Inject constructor(
    private val repositoryImp: MarvelApiRepositoryImp
):GetCharacteresUseCase{
    override suspend fun invoke(): List<CharactersDTO> {

        return repositoryImp.getCharactersApi()
    }


}