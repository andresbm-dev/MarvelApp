package com.abm.marvelapp.domain.usecase

import com.abm.marvelapp.data.repository.MarvelApiRepositoryImp
import com.abm.marvelapp.domain.model.CharactersDTO
import com.abm.marvelapp.domain.model.DataMarvelDTO
import com.abm.marvelapp.utils.ApiResponseStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetCharacteresUseCaseImp @Inject constructor(
    private val repositoryImp: MarvelApiRepositoryImp
):GetCharacteresUseCase{
    override suspend fun invoke(): Single<ApiResponseStatus<CharactersDTO>>{

        return when(val result = repositoryImp.getCharactersApi()){
            else -> Single.just(result)
        }
    }

}