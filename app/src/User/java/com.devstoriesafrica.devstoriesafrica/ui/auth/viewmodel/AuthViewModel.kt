package com.devstoriesafrica.devstoriesafrica.ui.auth.viewmodel

import androidx.lifecycle.*
import com.devstoriesafrica.devstoriesafrica.data.datastore.DataStoreManager
import com.devstoriesafrica.devstoriesafrica.models.responses.LoginResponse
import com.devstoriesafrica.devstoriesafrica.repositories.auth.AuthRepository
import com.devstoriesafrica.devstoriesafrica.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val preferences: DataStoreManager
) : ViewModel() {
    // Login Response is a dummy class and will be changed to respective responses
    // TODO: Change response classes
    private val _loginStatus = MutableLiveData<Resource<LoginResponse>>()
    val loginStatus: LiveData<Resource<LoginResponse>> = _loginStatus

    private val _signUpStatus = MutableLiveData<Resource<LoginResponse>>()
    val signUpStatus: LiveData<Resource<LoginResponse>> = _signUpStatus

    private val _resetPasswordStatus = MutableLiveData<Resource<LoginResponse>>()
    val resetPasswordStatus: LiveData<Resource<LoginResponse>> = _resetPasswordStatus

    private val _verifyOtpStatus = MutableLiveData<Resource<LoginResponse>>()
    val verifyOtpStatus: LiveData<Resource<LoginResponse>> = _verifyOtpStatus

    fun login(email: String, password: String) {
        _loginStatus.postValue(Resource.loading(null))

        viewModelScope.launch {
            val response = repository.login(
                email = email,
                password = password
            )
            _loginStatus.postValue(response)
        }
    }

    fun signUp(
        userName: String,
        email: String,
        password: String
    ) {
        _signUpStatus.postValue(Resource.loading(null))

        viewModelScope.launch {
            val response = repository.signUp(
                userName = userName,
                email = email,
                password = password
            )
            _signUpStatus.postValue(response)
        }
    }

    fun resetPassword(email: String) {
        _resetPasswordStatus.postValue(Resource.loading(null))

        viewModelScope.launch {
            val response = repository.resetPassword(
                email = email
            )
            _resetPasswordStatus.postValue(response)
        }
    }

    fun verifyOtp(email: String, otp: String) {
        _verifyOtpStatus.postValue(Resource.loading(null))

        viewModelScope.launch {
            val response = repository.verifyOtp(
                email = email,
                otp = otp
            )
            _verifyOtpStatus.postValue(response)
        }
    }

    fun onBoardingFinished() {
        viewModelScope.launch {
            preferences.saveOnboardingFinished(true)
        }
    }
}
