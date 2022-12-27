package com.abm.marvelapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "hero_table")
data class HeroEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String? = null,
    var imageFlag : String? = null,
    var isFavorite:Boolean = false
)