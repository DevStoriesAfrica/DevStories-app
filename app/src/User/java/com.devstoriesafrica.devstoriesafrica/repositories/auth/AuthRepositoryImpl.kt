package com.devstoriesafrica.devstoriesafrica.repositories.auth

import com.devstoriesafrica.devstoriesafrica.data.remote.DevStoriesApi
import com.devstoriesafrica.devstoriesafrica.models.requests.Login
import com.devstoriesafrica.devstoriesafrica.models.requests.ResetPassword
import com.devstoriesafrica.devstoriesafrica.models.requests.SignUp
import com.devstoriesafrica.devstoriesafrica.models.requests.VerifyOtp
import com.devstoriesafrica.devstoriesafrica.models.responses.LoginResponse
import com.devstoriesafrica.devstoriesafrica.utils.Resource
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: DevStoriesApi
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): Resource<LoginResponse> {
        return try {
            val response = api.signInUser(
                Login(
                    email = email,
                    password = password
                )
            )
            Resource.success(response)
        } catch (e: Exception) {
            return if (e is HttpException) {
                Resource.error(e.message(), null)
            } else {
                Resource.error("$e", null)
            }
        }
    }

    override suspend fun signUp(
        userName: String,
        email: String,
        password: String
    ): Resource<LoginResponse> {
        return try {
            val response = api.signUpUser(
                SignUp(
                    userName = userName,
                    email = email,
                    password = password
                )
            )
            Resource.success(response)
        } catch (e: Exception) {
            return if (e is HttpException) {
                Resource.error(e.message(), null)
            } else {
                Resource.error("$e", null)
            }
        }
    }

    override suspend fun resetPassword(email: String): Resource<LoginResponse> {
        return try {
            val response = api.resetPassword(
                ResetPassword(email = email)
            )
            Resource.success(response)
        } catch (e: Exception) {
            return if (e is HttpException) {
                Resource.error(e.message(), null)
            } else {
                Resource.error("$e", null)
            }
        }
    }

    override suspend fun verifyOtp(email: String, otp: String): Resource<LoginResponse> {
        return try {
            val response = api.verifyOtp(
                VerifyOtp(
                    email = email,
                    otp = otp
                )
            )
            Resource.success(response)
        } catch (e: Exception) {
            return if (e is HttpException) {
                Resource.error(e.message(), null)
            } else {
                Resource.error("$e", null)
            }
        }
    }
}