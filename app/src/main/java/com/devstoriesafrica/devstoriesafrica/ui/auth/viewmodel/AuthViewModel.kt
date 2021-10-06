package com.devstoriesafrica.devstoriesafrica.ui.auth.viewmodel

import androidx.lifecycle.ViewModel
import com.devstoriesafrica.devstoriesafrica.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
}