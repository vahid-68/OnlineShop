package com.example.onlineshop.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.onlineshop.ui.theme.Orange
import com.example.onlineshop.viewModel.LoginViewModel

@Composable
fun RegisterScreen(
    viewModel: LoginViewModel = hiltViewModel(),

    navController: NavController
) {
    var username by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val stateRegister by viewModel.stateRegister.collectAsState()

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
BackgroundApp()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier

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
            TwoColorText(text1 = "فروشگاه اینترنتی ",
                text2 = "آنلاین شاپ",
                color1 = Black,
                color2 = Orange,
                fontSize = 17,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .offset(y = (-45).dp)
            )
            SpacerHeight(9)


            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 5.dp),
                text = " نام و نام خانوادگی",

                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    textDirection = TextDirection.Rtl
                )
            )

            CustomTextField(fullName, onValueChange = {fullName=it}, TextDirection.Rtl, placeholder = "نام و نام خانوادگی")

            SpacerHeight(15)
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 5.dp),
                text = "شماره همراه",

                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    textDirection = TextDirection.Rtl
                )
            )
            CustomTextField(phone, onValueChange = {phone=it}, placeholder = "شماره همراه", type = KeyboardType.Number)
            SpacerHeight(15)

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 5.dp),
                text = "ایمیل",

                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    textDirection = TextDirection.Rtl
                )
            )
            CustomTextField(email, onValueChange = {email=it}, placeholder = "ایمیل", type = KeyboardType.Email)
            SpacerHeight(15)

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 5.dp),
                text = "نام کاربری",

                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    textDirection = TextDirection.Rtl
                )
            )
            CustomTextField(username, onValueChange = {username=it}, placeholder = "UserName")
            SpacerHeight(15)


            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                text = "رمز ورود",

                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    textDirection = TextDirection.Rtl
                )
            )
            SpacerHeight(9)
            CustomTextField(pass,onValueChange = {pass=it}, placeholder = "PassWord", type = KeyboardType.Password)
            SpacerHeight(20)
            CustomButton("ثبت نام", onClick = {
                viewModel.register(fullName, phone,email,username,pass)
            })
            if (stateRegister ) {
                Toast.makeText(context, "ثبت نام انجام شد", Toast.LENGTH_SHORT).show()
                navController.navigate(Screens.Login.route)
            }


        }
    }


}

