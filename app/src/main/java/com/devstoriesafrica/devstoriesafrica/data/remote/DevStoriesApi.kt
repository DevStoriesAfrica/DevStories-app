package com.devstoriesafrica.devstoriesafrica.data.remote

import com.devstoriesafrica.devstoriesafrica.models.requests.Login
import com.devstoriesafrica.devstoriesafrica.models.requests.SignUp
import com.devstoriesafrica.devstoriesafrica.models.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface DevStoriesApi {

    @POST("signup")
    suspend fun signUpUser(
        @Body signUp: SignUp
    ): LoginResponse

    @POST("signin")
    suspend fun signInUser(
        @Body login: Login
    ): LoginResponse

}