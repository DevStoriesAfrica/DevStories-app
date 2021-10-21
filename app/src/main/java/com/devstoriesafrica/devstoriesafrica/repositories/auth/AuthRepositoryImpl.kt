package com.devstoriesafrica.devstoriesafrica.repositories.auth

import com.devstoriesafrica.devstoriesafrica.data.remote.DevStoriesApi
import com.devstoriesafrica.devstoriesafrica.models.requests.Login
import com.devstoriesafrica.devstoriesafrica.models.responses.LoginResponse
import com.devstoriesafrica.devstoriesafrica.utils.Resource
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: DevStoriesApi
): AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): Resource<LoginResponse>{
        return try {
            val response = api.signInUser(
                Login(
                    email = email,
                    password = password
                )
            )
            Resource.success(response)
        } catch (e: Exception){
            return if (e is HttpException){
                Resource.error("",null)
            }else{
                Resource.error("",null)
            }
        }
    }
}