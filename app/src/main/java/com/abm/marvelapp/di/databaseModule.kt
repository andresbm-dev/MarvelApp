package com.abm.marvelapp.di


import android.content.Context
import androidx.room.Room
import com.abm.marvelapp.data.local.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object databaseModule {
    private const val HERO_DATA_BASE_NAME = "hero_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)= Room.databaseBuilder(context, AppDataBase::class.java, HERO_DATA_BASE_NAME).build()

    @Singleton
    @Provides
    fun provideHeroDao(db: AppDataBase) = db.heroesDao()

    @Singleton
    @Provides
    fun provideFavoriteHeroDao(db: AppDataBase) = db.heroesFavoriteDao()

}