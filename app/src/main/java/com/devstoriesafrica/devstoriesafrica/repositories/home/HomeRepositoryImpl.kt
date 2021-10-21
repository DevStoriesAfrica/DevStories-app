package com.devstoriesafrica.devstoriesafrica.repositories.home

import android.util.Log
import com.devstoriesafrica.devstoriesafrica.data.remote.EventBriteApi
import com.devstoriesafrica.devstoriesafrica.models.responses.GetEventsResponse
import com.devstoriesafrica.devstoriesafrica.utils.Constants.Companion.ORG_ID
import com.devstoriesafrica.devstoriesafrica.utils.Resource
import retrofit2.HttpException
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: EventBriteApi
): HomeRepository {

    override suspend fun getEvents(): Resource<GetEventsResponse>{
        return try {
            val response = api.getEvents(
                orgId = ORG_ID
            )
            Log.d("BRITERES","$response")
            Resource.success(response)
        } catch (e: Exception){
            return if (e is HttpException) {
                Log.d("BRITERESErr","$e")
                Resource.error(e.message(),null)
            } else {
                Resource.error("Could not connect to servers, $e", null)
            }
        }
    }
}