package com.abm.marvelapp.di

import com.abm.marvelapp.domain.usecase.GetCharacteresUseCase
import com.abm.marvelapp.domain.usecase.GetCharacteresUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun providesCountriesApiUseCase(useCaseImp: GetCharacteresUseCaseImp): GetCharacteresUseCase

   // @Binds
    //abstract fun providesCountriesLocalUseCase(useCaseImp: GetCountriesLocalUseCaseImp): GetCountriesLocalUseCase

}