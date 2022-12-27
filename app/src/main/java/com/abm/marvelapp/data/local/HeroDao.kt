package com.abm.marvelapp.data.local

import androidx.room.*

@Dao
interface HeroDao {
    @Query("SELECT * FROM hero_table")
    suspend fun getAllCountriesDao(): List<HeroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: HeroEntity)

}