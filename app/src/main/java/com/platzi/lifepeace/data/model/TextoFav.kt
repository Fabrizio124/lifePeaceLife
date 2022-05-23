package com.platzi.lifepeace.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TextoFav (
    @PrimaryKey
     val casoPrimero: String
)