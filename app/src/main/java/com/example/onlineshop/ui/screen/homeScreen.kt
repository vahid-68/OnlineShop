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
import com.example.onlineshop.data.model.BannerItemModel
import com.example.onlineshop.ui.component.BackgroundApp
import com.example.onlineshop.ui.component.CustomBannerSlider
import com.example.onlineshop.ui.component.DropdownCardMenu

import com.example.onlineshop.ui.component.HeaderApp
import com.example.onlineshop.R
import com.example.onlineshop.data.model.CategoryItemModel
import com.example.onlineshop.ui.component.CustomCategorySlider
import com.example.onlineshop.ui.component.CustomTextField
import com.example.onlineshop.ui.component.SpacerHeight
import com.example.onlineshop.ui.theme.Green1
import com.example.onlineshop.ui.theme.Green2
import com.example.onlineshop.ui.theme.Green3
import com.example.onlineshop.ui.theme.Green4
import com.example.onlineshop.ui.theme.LightOrange
import com.example.onlineshop.ui.theme.Orange
import com.example.onlineshop.ui.theme.Orange2
import com.example.onlineshop.ui.theme.Yellow

@Composable
fun HomeScreen(

) {
    var menuExpanded by remember { mutableStateOf(false) }
    var stateSearch by remember { mutableStateOf("") }
    val banners = listOf(
        BannerItemModel(
            imageRes = R.drawable.banner_product2,
            title = "از ورزشت لذت ببر!",
            text = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها",

            description = "",

            discount = true,


            ),

        BannerItemModel(
            R.drawable.banner_product,
            "از ورزشت لذت ببر!",
            description = "",
            text = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها",

            
            bgGradient = listOf(Orange2, LightOrange),
            circleGradient = listOf(Orange,LightOrange)
        ),
        BannerItemModel(
            R.drawable.banner_product2,
            "از ورزشت لذت ببر!",
            description = "",
            text = "تولید و عرضه انواع کفش های اسپرت در همه سایز ها",

discount = true
            )
    )

    val categories = listOf(
        CategoryItemModel(
            imageRes = R.drawable.img_category_man,

            title = "مردانه"
        ),
        CategoryItemModel(
            imageRes = R.drawable.img_category_woman,

            title = "زنانه"
        ),
        CategoryItemModel(
            imageRes = R.drawable.img_category_girl,

            title = "دخترانه"
        ),
        CategoryItemModel(
            imageRes = R.drawable.img_category_boy,

            title = "پسرانه"
        ),
        CategoryItemModel(
            imageRes = R.drawable.img_category_baby,

            title = "نوزادی"
        ),
        CategoryItemModel(
            imageRes = R.drawable.img_category_shoes,

            title = "کفش"
        ),


        )

    Box(
        modifier = Modifier
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
                            .padding(horizontal = 9.dp)
                    ) {
                        SpacerHeight(20)
                        CustomBannerSlider(
                            banners = banners,

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
                                    modifier = Modifier
                                        .size(20.dp)
                                        .offset(x = (-10).dp)

                                )
                            }
                        )

                        SpacerHeight(20)

                        CustomCategorySlider(
                            categories = categories,

                            onCategoryClick = {

                            }

                        )
SpacerHeight(30)
                        Text(
                            text = "پرفروش ترین ها",

                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Row(
                                modifier = Modifier
                                    .width(110.dp)

                                    .padding(top = 9.dp, start = 5.dp)
                                    .clickable{
                                    },

                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.Bottom



                            ) {

                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier


                                ) {

                                    Icon(
                                        painter = painterResource(R.drawable.ic_arrow_left),
                                        contentDescription = "arrow_left",
                                        tint = Orange2,
                                        modifier = Modifier
                                            .size(21.dp)
                                            .offset(x = (7).dp,y=(-2).dp)

                                    )
                                    Icon(
                                        painter = painterResource(R.drawable.ic_long_dash),
                                        contentDescription = "arrow_left",
                                        tint = Orange2,
                                        modifier = Modifier
                                            .size(11.dp)
                                            .offset(x = (-6).dp,y=(-2).dp)

                                    )

                                    Icon(
                                        painter = painterResource(R.drawable.ic_short_dash),
                                        contentDescription = "arrow_left",
                                        tint = Orange2,
                                        modifier = Modifier
                                            .size(5.dp)
                                            .offset(x = (-4).dp,y=(-2).dp)

                                    )


                                }
                                Text(
                                    text = "مشاهده همه",
                                    color = Color.Black,
                                    fontSize = 13.sp,



                                )

                            }


                            Text(
                                text = "پرفروش ترین ها",

                                modifier = Modifier

                                    .padding(end = 22.dp),

                            textAlign = TextAlign.Right,

                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,

                            style = TextStyle(textDirection = TextDirection.Rtl)

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




