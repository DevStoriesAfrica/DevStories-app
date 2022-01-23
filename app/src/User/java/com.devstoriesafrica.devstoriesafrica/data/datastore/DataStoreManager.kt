package com.devstoriesafrica.devstoriesafrica.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.devstoriesafrica.devstoriesafrica.models.responses.LoginResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManager @Inject constructor(val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "com.devstoriesafrica.devstoriesafrica")

    companion object {
        val USERNAME = stringPreferencesKey("USERNAME")
        val EMAIL = stringPreferencesKey("EMAIL")
        val ACCESS_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
        val IS_LOGIN = booleanPreferencesKey("IS_LOGIN")
        val ONBOARDING_FINISHED = booleanPreferencesKey("ONBOARDING_FINISHED")
    }

    suspend fun saveUserRecords(loginResponse: LoginResponse) {
        context.dataStore.edit {
            it[IS_LOGIN] = loginResponse.message
        }
    }

    val getOnboardingFinished: Flow<Boolean?> = context.dataStore.data.map {
        it[ONBOARDING_FINISHED]
    }

    suspend fun saveOnboardingFinished(isOnboardingFinshed: Boolean) {
        context.dataStore.edit { it[ONBOARDING_FINISHED] = isOnboardingFinshed }
    }

    suspend fun getUserRecordsFromDataStore() = context.dataStore.data.map {
        LoginResponse(
            message = it[IS_LOGIN] ?: false
        )
    }
}
