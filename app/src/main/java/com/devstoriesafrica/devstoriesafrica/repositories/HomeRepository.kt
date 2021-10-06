package com.devstoriesafrica.devstoriesafrica.repositories

import com.devstoriesafrica.devstoriesafrica.data.remote.DevStoriesApi
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val api: DevStoriesApi
) {
}