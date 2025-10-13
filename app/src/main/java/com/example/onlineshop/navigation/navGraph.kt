package com.example.onlineshop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onlineshop.ui.screen.HomeScreen
import com.example.onlineshop.ui.screen.LoginScreen
import com.example.onlineshop.ui.screen.RegisterScreen
import com.example.onlineshop.ui.screen.SplashScreen


@Composable
fun SetupNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    )
    {
        composable(
            route = Screens.Login.route,

            ){

            LoginScreen(navController = navController)
        }

        composable(
            route = Screens.Register.route,

        ){

            RegisterScreen(navController = navController)

        }

        composable(
            route = Screens.Home.route,
        ){
            HomeScreen()
        }

        composable (
            route= Screens.Splash.route
        ){
            SplashScreen(navController=navController)
        }




    }
}


