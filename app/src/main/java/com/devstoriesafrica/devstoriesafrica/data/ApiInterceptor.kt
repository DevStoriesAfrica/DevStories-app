package com.devstoriesafrica.devstoriesafrica.data

import android.content.Context
import com.devstoriesafrica.devstoriesafrica.utils.Constants.Companion.TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor(@ApplicationContext context: Context): Interceptor  {

    override fun intercept(chain: Interceptor.Chain): Response = runBlocking {
        val token = TOKEN
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .addHeader("Authorization", "Bearer $token")
        val request = requestBuilder.build()
        chain.proceed(request)
    }
}