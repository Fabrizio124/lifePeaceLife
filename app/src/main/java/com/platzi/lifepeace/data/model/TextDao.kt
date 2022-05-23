package com.platzi.lifepeace.data.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TextDao {
    @Query("SELECT * FROM TextoFav ")
    suspend fun getAllTexts():List<TextoFav>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(texto: kotlin.String)
}