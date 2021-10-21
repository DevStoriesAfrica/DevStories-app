package com.devstoriesafrica.devstoriesafrica.data.remote

import com.devstoriesafrica.devstoriesafrica.models.responses.GetEventsResponse
import com.devstoriesafrica.devstoriesafrica.utils.Constants.Companion.LIST_EVENTS
import retrofit2.http.GET
import retrofit2.http.Path

interface EventBriteApi {

    //display events
    @GET(LIST_EVENTS)
    suspend fun getEvents(
        @Path("organization_id") orgId: String
    ): GetEventsResponse

}