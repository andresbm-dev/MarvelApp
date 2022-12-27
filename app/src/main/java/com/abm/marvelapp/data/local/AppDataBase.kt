package com.abm.marvelapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [HeroEntity::class] , version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun heroesDao(): HeroDao
    abstract fun heroesFavoriteDao(): HeroFavoriteDao
}