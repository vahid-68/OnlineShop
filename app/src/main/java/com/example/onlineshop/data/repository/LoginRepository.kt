package com.example.onlineshop.data.repository

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.onlineshop.data.local.ds.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LoginRepository @Inject constructor(
    @ApplicationContext context: Context,  //برای اینکه به دیتا استور دسترسی داشته باشیم باید توی ورودی
    //  به این صورت کانتکس صدا بزنیم و دیتا استور را صدا زده
) {
    private val dataStore = context.dataStore


    companion object {
        val USERNAME_KEY =
            stringPreferencesKey("username") //توی یک آبجکت کلید مقدار تعریف میکنیم تا
        val PASSWORD_KEY = stringPreferencesKey("pass") // توی ذخیره کردن در دیتا استور استفاده کنیم

        val LOGGED_IN_KEY = booleanPreferencesKey("is_logged_in")
        val FULLNAME_KEY = stringPreferencesKey("fullname")

        val PHONE_KEY = stringPreferencesKey("phone")
        val EMAIL_KEY = stringPreferencesKey("email")
    }

    suspend fun setUserData(
        fullName: String,
        phone: String,
        email: String,
        username: String,
        pass: String,
        loggedIn: Boolean = true

    ) {                                  // هرکی این فانکشن را صدا بزنه یک یوز و یک پسورد
        // باید بهش بده

        dataStore.edit { it ->
            it[FULLNAME_KEY] = fullName// بعد دیتا استور میاد اون کلید هایی که تعریف کردیم مقدارشو همین یوزر و
            it[USERNAME_KEY] = username  // پسورد که توی ورودی گرفتیم قرار میده و ذخیره میکنه
            it[PASSWORD_KEY] = pass
            it[PHONE_KEY] = phone
            it[EMAIL_KEY] = email
            it[LOGGED_IN_KEY] = loggedIn
        }
    }

    suspend fun userDataValidation(username: String, pass: String): Boolean {  //فانکشنی تعریف میکنیم توی ورودی یوز و پسورد میگیره از کاربر اعتبارسنجی کنه که
        val data = dataStore.data.first()
        return data[USERNAME_KEY] == username && data[PASSWORD_KEY] == pass   // آیا یوزر و پسورد ذخیره شده با یوزر و پسورد وارد شده برابر است یا نه

    }


    suspend fun isUserLoggedIn(): Boolean {
        val data = dataStore.data.first()
        return data[LOGGED_IN_KEY] ?: false
    }


}