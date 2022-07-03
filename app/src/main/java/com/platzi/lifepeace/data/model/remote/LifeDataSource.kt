package com.platzi.lifepeace.data.model.remote

import com.platzi.lifepeace.application.AppConstants
import com.platzi.lifepeace.repository.WebService

class LifeDataSource(private val webService: WebService) {

    suspend fun getUpcomingLife() : LifeList = webService.getUpcomingLife(AppConstants.BASE_URL)

}