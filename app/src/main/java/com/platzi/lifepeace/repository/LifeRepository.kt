package com.platzi.lifepeace.repository

import com.platzi.lifepeace.data.model.remote.LifeList

interface LifeRepository {
    suspend fun getUpcomingLife(): LifeList
}