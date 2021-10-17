package com.devstoriesafrica.devstoriesafrica.di

import android.content.Context
import com.devstoriesafrica.devstoriesafrica.data.ApiInterceptor
import com.devstoriesafrica.devstoriesafrica.data.remote.DevStoriesApi
import com.devstoriesafrica.devstoriesafrica.data.remote.EventBriteApi
import com.devstoriesafrica.devstoriesafrica.utils.Constants.Companion.BASE_URL
import com.devstoriesafrica.devstoriesafrica.utils.Constants.Companion.EVENTBRITE_API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi(
        @ApplicationContext context: Context
    ): EventBriteApi {
        val apiInterceptor = ApiInterceptor(context)
        val client = OkHttpClient.Builder().addInterceptor(apiInterceptor).build()

        return Retrofit.Builder()
            .baseUrl(EVENTBRITE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(EventBriteApi::class.java)
    }


    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ) = context

}