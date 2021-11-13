package com.devstoriesafrica.devstoriesafrica.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.devstoriesafrica.devstoriesafrica.models.responses.LoginResponse
import kotlinx.coroutines.flow.map

class DataStoreManager(val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "USER_DATASTORE")


    companion object {
        val USERNAME = stringPreferencesKey("USERNAME")
        val EMAIL = stringPreferencesKey("EMAIL")
        val ACCESS_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
        val IS_LOGIN = booleanPreferencesKey("IS_LOGIN")

    }

    suspend fun saveUserRecords(loginResponse: LoginResponse) {
        context.dataStore.edit {
            it[IS_LOGIN] = loginResponse.message
        }
    }

    suspend fun getUserRecordsFromDataStore() = context.dataStore.data.map {
        LoginResponse(
            message = it[IS_LOGIN]?: false
        )
    }
}