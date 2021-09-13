package com.platzi.lifepeace.model

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface TextDao {
    @Query("SELECT * FROM TextoFav ")
    suspend fun getAllTexts():List<TextoFav>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(trago:TextoFav)
}