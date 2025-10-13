package com.example.onlineshop.navigation

import kotlin.collections.forEachIndexed

sealed class Screens(val route: String) {
    object Login: Screens("login")

    object Register : Screens("register")

    object Home : Screens("home")

    object Splash: Screens("splash")




    fun routeWithArgs(vararg args: String)=
        buildString {
            append(route)
            args.forEachIndexed { index, value ->
                append("?$index={$index}")
            }
        }

    fun paramsWithArgs(vararg args: String)=
        buildString {
            append(route)
            args.forEachIndexed { index, value ->
                append("?$index=$value")
            }

        }
}