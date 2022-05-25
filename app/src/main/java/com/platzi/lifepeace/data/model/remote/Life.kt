package com.platzi.lifepeace.data.model.remote

import com.google.gson.annotations.SerializedName

data class LifeList (

    @SerializedName("quote"  ) var quote  : String? = null,
    @SerializedName("author" ) var author : String? = null

)