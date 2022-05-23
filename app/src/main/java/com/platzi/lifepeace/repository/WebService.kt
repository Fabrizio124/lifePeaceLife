package com.platzi.lifepeace.repository

import com.google.gson.GsonBuilder
import com.platzi.lifepeace.application.AppConstants
import com.platzi.lifepeace.data.model.remote.LifeList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET("https://free-quotes-api.herokuapp.com/")
    suspend fun getUpcomingLife(baseUrl: String): LifeList
}

object RetrofitClient {
    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}