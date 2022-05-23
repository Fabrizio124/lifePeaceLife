package com.platzi.lifepeace.repository

import com.platzi.lifepeace.data.model.remote.LifeDataSource
import com.platzi.lifepeace.data.model.remote.LifeList

//Creamos una instancia dentro del constructor del repositorio

class LifeRepositoryImpl(private val dataSource: LifeDataSource): LifeRepository {

    override suspend fun getUpcomingLife(): LifeList = dataSource.getUpcomingLife()
}