package com.example.onlineshop.data.repository

import android.util.Log
import com.google.gson.JsonSyntaxException
import okio.IOException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton     // از سینگل تون استفاده میکنیم تا یکبار آبجکت ساخته شه
 class ApiRepository @Inject constructor(){

    suspend fun<T> safeGetData(request: suspend () -> T): Result<T> {
        return try {
            val response = request()
            Result.success(response)
        } catch (e: Exception) {

            when(e){
                is SocketTimeoutException -> Log.e("TAG", "Timeout Error")
                is IOException -> Log.e("TAG", "Connection Error")
                is HttpException -> Log.e("TAG", "HTTP ${e.code()}: ${e.message()}")
                is JsonSyntaxException -> Log.e("TAG", "JSON Error")
                else -> Log.e("TAG", "Unknown Error: ${e.message}")
            }

            Result.failure(e)
        }

    }





}