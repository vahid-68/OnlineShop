package com.example.onlineshop.ui.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController


import com.example.onlineshop.R



import com.example.onlineshop.navigation.Screens
import com.example.onlineshop.ui.component.BackgroundApp
import com.example.onlineshop.ui.component.CustomButton
import com.example.onlineshop.ui.component.CustomTextField

import com.example.onlineshop.ui.component.MainLogo
import com.example.onlineshop.ui.component.OnlineShopLogo
import com.example.onlineshop.ui.component.SpacerHeight
import com.example.onlineshop.ui.component.TwoColorText
import com.example.onlineshop.ui.theme.Black
import com.example.onlineshop.ui.theme.GrayBlack
import com.example.onlineshop.ui.theme.GrayLight
import com.example.onlineshop.ui.theme.Orange
import com.example.onlineshop.viewModel.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavController
) {
    var username by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    val stateLogin by viewModel.stateLogin.collectAsState()
    val message = viewModel.message
    val context = LocalContext.current




    Box(

        modifier = Modifier.fillMaxSize(),

        ) {
        BackgroundApp()


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())




        ) {
            MainLogo(
                image= R.drawable.ic_logo,

                imageSize = 100.dp,

                modifier = Modifier
                    .offset(),

                )

            OnlineShopLogo(

                image = R.drawable.online_shop,
                imageSize = 100.dp,

                modifier = Modifier
                    .offset(),


                )
            TwoColorText(
                text1 = "فروشگاه اینترنتی ",
                text2 = "آنلاین شاپ",
                color1 = Black,
                color2 = Orange,
                fontSize = 19,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .offset(y = (-120).dp)



            )
            Column (
                modifier = Modifier
                    .padding(bottom = 60.dp)

            ){
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    text = "نام کاربری",

                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        textDirection = TextDirection.Rtl
                    )
                )
                SpacerHeight(9)



                CustomTextField(username, onValueChange = {username=it}, placeholder = "UserName")
                SpacerHeight(15)
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    text = "رمز ورود",

                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        textDirection = TextDirection.Rtl
                    )
                )
                SpacerHeight(9)
                CustomTextField(pass,onValueChange = {pass=it}, placeholder = "PassWord", type = KeyboardType.Password)
                SpacerHeight(25)
                CustomButton("ورود", onClick = {
                    viewModel.login(username, pass)}
                )
                SpacerHeight(15)
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp)
                ){

                    Text(
                        text = "ثبت نام",
                        modifier = Modifier
                            .clickable{
                                navController.navigate(Screens.Register.route)
                            }
                            .padding(end = 10.dp),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = GrayBlack

                    )

                    if (stateLogin) {
                        navController.navigate(Screens.Home.route){
                            popUpTo(Screens.Login.route) {
                                inclusive=true
                            }
                        }


                    }
                    LaunchedEffect(Unit) {
                        message.collect {
                            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                        }
                    }
                    Text(
                        text = "هنوز ثبت نام نکرده اید؟",
                        fontSize = 15.sp,
                        color = GrayLight


                    )
                }


            }


        }




    }






}


