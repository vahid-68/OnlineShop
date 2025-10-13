package com.example.onlineshop.data.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    @SerializedName("name") val fullName: String,
    val username: String,
    val email: String,




    val website: String,
    val company: Company

)

data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)