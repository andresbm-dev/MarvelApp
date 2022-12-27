package com.abm.marvelapp.data.local

import androidx.room.*

@Dao
interface HeroFavoriteDao {
    @Query("SELECT * FROM hero_table WHERE isFavorite == 1 ORDER BY name DESC ")
    suspend fun getAllHeroesFav():List<HeroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFavorite(hero:HeroEntity)

    @Delete()
    suspend fun deleteFavorite( heroes : List<HeroEntity>)

}