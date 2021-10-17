package com.devstoriesafrica.devstoriesafrica.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devstoriesafrica.devstoriesafrica.models.GetEventsResponse
import com.devstoriesafrica.devstoriesafrica.repositories.HomeRepository
import com.devstoriesafrica.devstoriesafrica.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

    private val _getEventsStatus = MutableLiveData<Resource<GetEventsResponse>>()
    val getEventsStatus: LiveData<Resource<GetEventsResponse>> = _getEventsStatus


    fun getEvents(){
        viewModelScope.launch {
            val result = repository.getEvents()

            _getEventsStatus.postValue(result)
        }
    }




}