package com.platzi.lifepeace.data.model

import com.platzi.lifepeace.data.model.remote.LifeList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface TextDao {
    @GET
    fun getFrases(@Url url:String): Response<LifeList>

}