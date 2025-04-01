package com.example.store.ui.theme

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

class StoreUserMail ( private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserMail")
        val USER_MAIL= stringPreferencesKey("user_mail")
    }
    val getEmail: Flow<String> = context.dataStore.data
        .map{preference->
            preference[USER_MAIL] ?: ""
        }
    suspend fun saveMail(mail: String) {
        context.dataStore.edit { preference ->
            preference[USER_MAIL] = mail
        }
    }}