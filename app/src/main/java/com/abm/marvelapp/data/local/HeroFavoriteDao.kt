package com.abm.marvelapp.data.local

import androidx.room.*

@Dao
interface HeroFavoriteDao {
    @Query("SELECT * FROM hero_table WHERE isFavorite == 1 ORDER BY name DESC ")
    suspend fun getAllCatFav():List<HeroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFavorite(cat:HeroEntity)

    @Delete()
    suspend fun deleteFavorite( cats : List<HeroEntity>)

}