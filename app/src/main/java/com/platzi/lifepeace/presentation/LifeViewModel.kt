package com.platzi.lifepeace.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.platzi.lifepeace.core.Resource
import com.platzi.lifepeace.repository.LifeRepository
import kotlinx.coroutines.Dispatchers

class LifeViewModel(private val repo: LifeRepository): ViewModel() {

    fun fetchLife() = liveData(Dispatchers.IO) {
      emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getUpcomingLife()))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
        }
    }
}

class LifeViewModelFactory(private val repo:LifeRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(LifeRepository::class.java).newInstance(repo)
    }
}