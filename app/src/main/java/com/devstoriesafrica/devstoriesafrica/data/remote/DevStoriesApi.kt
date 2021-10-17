package com.devstoriesafrica.devstoriesafrica.data.remote

import okhttp3.Response
import retrofit2.http.POST

interface DevStoriesApi {

    @POST("signup")
    suspend fun signUpUser(): Response

    @POST("signing")
    suspend fun signInUser(): Response

}