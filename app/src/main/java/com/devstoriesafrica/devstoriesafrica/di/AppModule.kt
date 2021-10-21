package com.devstoriesafrica.devstoriesafrica.di

import android.content.Context
import com.devstoriesafrica.devstoriesafrica.data.ApiInterceptor
import com.devstoriesafrica.devstoriesafrica.data.remote.DevStoriesApi
import com.devstoriesafrica.devstoriesafrica.data.remote.EventBriteApi
import com.devstoriesafrica.devstoriesafrica.repositories.auth.AuthRepository
import com.devstoriesafrica.devstoriesafrica.repositories.auth.AuthRepositoryImpl
import com.devstoriesafrica.devstoriesafrica.repositories.home.HomeRepository
import com.devstoriesafrica.devstoriesafrica.repositories.home.HomeRepositoryImpl
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
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
        val apiInterceptor = ApiInterceptor(context)
        val client = OkHttpClient.Builder().addInterceptor(apiInterceptor).build()

        return Retrofit.Builder()
            .baseUrl(EVENTBRITE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideEventBriteApi(retrofit: Retrofit): EventBriteApi {
        return retrofit.create(EventBriteApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDevStoriesApi(retrofit: Retrofit): DevStoriesApi {
        return retrofit.create(DevStoriesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideAuthRepository(api: DevStoriesApi): AuthRepository {
        return AuthRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideHomeRepository(api: EventBriteApi): HomeRepository {
        return HomeRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ) = context

}