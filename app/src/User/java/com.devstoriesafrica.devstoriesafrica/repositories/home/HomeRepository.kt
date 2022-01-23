package com.devstoriesafrica.devstoriesafrica.repositories.home

import com.devstoriesafrica.devstoriesafrica.models.responses.GetEventsResponse
import com.devstoriesafrica.devstoriesafrica.utils.Resource

interface HomeRepository {
    suspend fun getEvents(): Resource<GetEventsResponse>
}