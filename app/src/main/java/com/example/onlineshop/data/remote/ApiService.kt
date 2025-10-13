package com.example.onlineshop.data.remote

import com.example.onlineshop.data.model.User
import retrofit2.http.GET


interface ApiService{
    @GET("users")
    suspend  fun getUsers(): List<User>



}