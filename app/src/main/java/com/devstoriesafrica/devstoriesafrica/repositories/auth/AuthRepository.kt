package com.devstoriesafrica.devstoriesafrica.repositories.auth

import com.devstoriesafrica.devstoriesafrica.models.responses.LoginResponse
import com.devstoriesafrica.devstoriesafrica.utils.Resource

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<LoginResponse>
    suspend fun signUp(userName: String,email: String ,password: String): Resource<LoginResponse>
}