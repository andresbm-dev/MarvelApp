package com.abm.marvelapp.data.local

import androidx.room.*

@Dao
interface HeroDao {
    @Query("SELECT * FROM hero_table")
    suspend fun getAllHeroesDao(): List<HeroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroe: HeroEntity)

}