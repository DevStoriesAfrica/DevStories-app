package com.devstoriesafrica.devstoriesafrica.ui.home.viewmodel

import androidx.lifecycle.*
import com.devstoriesafrica.devstoriesafrica.data.datastore.DataStoreManager
import com.devstoriesafrica.devstoriesafrica.models.responses.GetEventsResponse
import com.devstoriesafrica.devstoriesafrica.repositories.home.HomeRepository
import com.devstoriesafrica.devstoriesafrica.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val preferences: DataStoreManager
) : ViewModel() {

    private val _getEventsStatus = MutableLiveData<Resource<GetEventsResponse>>()
    val getEventsStatus: LiveData<Resource<GetEventsResponse>> = _getEventsStatus

    var onBoardingFinished = false

    init {
        isOnBoardingFinished()
    }

    fun getEvents() {
        viewModelScope.launch {
            val result = repository.getEvents()

            _getEventsStatus.postValue(result)
        }
    }

    private fun isOnBoardingFinished() {
        viewModelScope.launch {
            preferences.getOnboardingFinished.collect {
                if (it != null) {
                    onBoardingFinished = true
                }
            }
        }
    }
}
