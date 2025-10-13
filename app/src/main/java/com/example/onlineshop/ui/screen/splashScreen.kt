package com.example.onlineshop.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController

import com.example.onlineshop.R

import com.example.onlineshop.navigation.Screens
import com.example.onlineshop.ui.component.BackgroundApp

import com.example.onlineshop.ui.component.MainLogo
import com.example.onlineshop.ui.component.OnlineShopLogo
import com.example.onlineshop.ui.theme.Orange
import com.example.onlineshop.viewModel.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val isLoggedIn by viewModel.isLoggedIn.collectAsState()

    LaunchedEffect(true) {
        delay(3000)
        if (isLoggedIn){
            navController.navigate(Screens.Home.route){
                popUpTo (Screens.Splash.route){
                    inclusive=true
                }
            }

        }else
        {
            navController.navigate(Screens.Login.route){
                popUpTo(Screens.Splash.route) {
                    inclusive=true
                }
            }
        }

    }



    Box(
        modifier = Modifier.fillMaxSize()
    )
    {
        BackgroundApp()

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ){
            MainLogo(
                image= R.drawable.ic_logo,

                imageSize = 100.dp,

                modifier = Modifier
                    .offset(),

                )

            OnlineShopLogo(

                image = R.drawable.online_shop,
                imageSize = 160.dp,

                modifier = Modifier
                    .offset(y = (-70).dp),


            )
        }

        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 65.dp)
                .size(35.dp),
            color = Orange,
            strokeWidth = 4.dp

        )

    }
}

