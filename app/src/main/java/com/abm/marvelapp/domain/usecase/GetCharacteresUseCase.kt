package com.abm.marvelapp.domain.usecase


import com.abm.marvelapp.domain.model.CharactersDTO
import com.abm.marvelapp.domain.model.DataMarvelDTO
import com.abm.marvelapp.utils.ApiResponseStatus
import io.reactivex.rxjava3.core.Single

interface GetCharacteresUseCase {
    suspend operator fun invoke(): Single<ApiResponseStatus<CharactersDTO>>
}