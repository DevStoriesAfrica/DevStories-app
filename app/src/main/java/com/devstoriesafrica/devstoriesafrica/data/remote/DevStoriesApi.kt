package com.devstoriesafrica.devstoriesafrica.data.remote

import com.devstoriesafrica.devstoriesafrica.models.requests.Login
import com.devstoriesafrica.devstoriesafrica.models.responses.LoginResponse
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DevStoriesApi {

    @POST("signup")
    suspend fun signUpUser(): Response

    @POST("signin")
    suspend fun signInUser(
        @Body login: Login
    ): LoginResponse

}