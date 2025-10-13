package com.example.onlineshop.di

import com.example.onlineshop.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaggerApiHandler { // مسٔول ساخت ای پی آی


    @Provides
    @Singleton
    fun provideClient():OkHttpClient =
     OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()


    @Provides
    fun provideBaseUrl() = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton  // یعنی فقط یکبار ساخته شه
    fun provideRetrofit(baseUrl: String,client: OkHttpClient): Retrofit =
                                                    // پروواید رتروفیت توی ورودی بیس یوآرال میگیره و
        Retrofit.Builder()                          //  رتروفیت رو میسازه و برمیگردونه
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
                                                 // رتروفیت را میسازیم تا بتوانیم ای پی آی سرویس را بسازیم
        retrofit.create(ApiService::class.java)  // کجا استفاده میشه؟کدام آبجکت و کلاسی استفاده میکنه؟
}                                              // هر آبجکتی که اینجکت شده باشه و
                                               //  توی ورودیش بگه من به ای پی آی سرویس نیاز دارم