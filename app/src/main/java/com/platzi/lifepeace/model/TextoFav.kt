package com.platzi.lifepeace.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.viewbinding.ViewBinding
import com.platzi.lifepeace.databinding.ActivityNuevaAnsiedadBinding
import com.platzi.lifepeace.nuevaAnsiedad

@Entity
data class TextoFav(
    @PrimaryKey
     val casoPrimero: String
)