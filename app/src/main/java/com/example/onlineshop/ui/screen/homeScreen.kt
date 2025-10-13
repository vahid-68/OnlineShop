package com.example.onlineshop.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.data.model.BannerSliderModel
import com.example.onlineshop.ui.component.BackgroundApp
import com.example.onlineshop.ui.component.CustomBannerSlider
import com.example.onlineshop.ui.component.DropdownCardMenu

import com.example.onlineshop.ui.component.HeaderApp
import com.example.onlineshop.R
import com.example.onlineshop.data.model.CategoryCardItem
import com.example.onlineshop.ui.component.CustomCategorySlider
import com.example.onlineshop.ui.component.CustomTextField
import com.example.onlineshop.ui.component.SpacerHeight
import com.example.onlineshop.ui.theme.Green1
import com.example.onlineshop.ui.theme.Green2
import com.example.onlineshop.ui.theme.Green3
import com.example.onlineshop.ui.theme.Green4
import com.example.onlineshop.ui.theme.Orange2
import com.example.onlineshop.ui.theme.Yellow

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    var menuExpanded by remember { mutableStateOf(false) }
    var stateSearch by remember { mutableStateOf("") }
    val bannerSliderModels = listOf(
        BannerSliderModel(
            R.drawable.banner_product2,
            "از ورزشت لذت ببر!",
            description = "",
            text = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها",
            backgroundStart = Green1,
            backgroundEnd = Green2,
            circleCenter = Green3,
            circleEdge = Green4,
            discount = true,
            modifier = Modifier
                .padding(end = 25.dp, bottom = 15.dp)

                .size(130.dp)
        ),
        BannerSliderModel(
            R.drawable.banner_product,
            "از ورزشت لذت ببر!",
            description = "",
            text = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها",
            backgroundStart = Green1,
            backgroundEnd = Green2,
            circleCenter = Green3,
            circleEdge = Green4,
            discount = true,
            modifier = Modifier
                .padding(end = 25.dp, bottom = 15.dp)

                .size(130.dp)
        ),

        BannerSliderModel(
            R.drawable.banner_product2,
            "از ورزشت لذت ببر!",
            description = "",
            text = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها",
            backgroundStart = Yellow,
            backgroundEnd = Orange2,
            circleCenter = Yellow,
            circleEdge = Orange2,
            modifier = Modifier
                .size(100.dp)
        ),

        )

    val categoryCardItems = listOf(
        CategoryCardItem(
            imageRes = R.drawable.img_category_man,

            title = "مردانه"
        ),
        CategoryCardItem(
            imageRes = R.drawable.img_category_woman,

            title = "زنانه"
        ),
        CategoryCardItem(
            imageRes = R.drawable.img_category_girl,

            title = "دخترانه"
        ),
        CategoryCardItem(
            imageRes = R.drawable.img_category_boy,

            title = "پسرانه"
        ),
        CategoryCardItem(
            imageRes = R.drawable.img_category_baby,

            title = "نوزادی"
        ),
        CategoryCardItem(
            imageRes = R.drawable.img_category_shoes,

            title = "کفش"
        ),





    )

    Box(
        modifier = modifier
            .fillMaxSize(),


        ) {
        BackgroundApp()

        Scaffold(


            containerColor = Color.Transparent,

            topBar = {
                HeaderApp(
                    menuExpanded = menuExpanded,
                    onMenuClick = { menuExpanded = !menuExpanded }
                )

            },
            content = { innerPadding ->


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {


                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 7.dp)
                    ) {
                        SpacerHeight(20)
                        CustomBannerSlider(
                            items = bannerSliderModels,

                            onItemClick = { title -> }
                        )
                        SpacerHeight(20)


                        Text(
                            text = "تنها با یک کلیک خرید کن!",

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 22.dp),

                            textAlign = TextAlign.Right,

                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,

                            style = TextStyle(textDirection = TextDirection.Rtl)

                        )
                        SpacerHeight(20)


                        CustomTextField(
                            stateSearch,
                            { stateSearch = it },
                            TextDirection.Rtl,
                            "  هرچی میخوای جستجوکن ...",
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_search),
                                    contentDescription = "search",
                                    tint = Orange2,
                                    modifier= Modifier
                                        .size(20.dp)
                                        .offset(x = (-10).dp)

                                )
                            }
                        )

                        SpacerHeight(20)

                        CustomCategorySlider(
                  categories = categoryCardItems,
                            onCategoryClick = {

                            }

                        )

                    }
                    DropdownCardMenu(
                        menuExpanded = menuExpanded,
                        onItemClick = { item ->
                            menuExpanded = false
                            when (item) {
                                "پروفایل کاربری" -> {}
                                "سفارشات من" -> {}
                                "پشتیبانی" -> {}
                                "قوانین و مقررات" -> {}
                                "درباره ما" -> {}
                                "ارتباط با ما" -> {}
                            }
                        }
                    )

                }








            }



        )
    }


}




