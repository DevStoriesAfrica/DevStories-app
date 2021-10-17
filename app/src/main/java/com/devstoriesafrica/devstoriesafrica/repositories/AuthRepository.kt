package com.devstoriesafrica.devstoriesafrica.repositories

import com.devstoriesafrica.devstoriesafrica.data.remote.DevStoriesApi
import com.devstoriesafrica.devstoriesafrica.data.remote.EventBriteApi
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: EventBriteApi
) {
}