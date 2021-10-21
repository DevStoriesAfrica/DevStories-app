package com.devstoriesafrica.devstoriesafrica.ui.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devstoriesafrica.devstoriesafrica.models.responses.LoginResponse
import com.devstoriesafrica.devstoriesafrica.repositories.auth.AuthRepository
import com.devstoriesafrica.devstoriesafrica.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    private val _loginStatus = MutableLiveData<Resource<LoginResponse>>()
    val loginStatus: LiveData<Resource<LoginResponse>> = _loginStatus


    fun login(email: String, password: String){
        _loginStatus.postValue(Resource.loading(null))

        viewModelScope.launch {
            val response = repository.login(
                email = email,
                password = password
            )
            _loginStatus.postValue(response)
        }
    }
}