package com.devstoriesafrica.devstoriesafrica.data.remote

import com.devstoriesafrica.devstoriesafrica.models.requests.Login
import com.devstoriesafrica.devstoriesafrica.models.requests.ResetPassword
import com.devstoriesafrica.devstoriesafrica.models.requests.SignUp
import com.devstoriesafrica.devstoriesafrica.models.requests.VerifyOtp
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

    @POST("reset")
    suspend fun resetPassword(
        @Body resetPassword: ResetPassword
    ): LoginResponse

    @POST("verifyOtp")
    suspend fun verifyOtp(
        @Body verifyOtp: VerifyOtp
    ): LoginResponse

}