package com.example.onlineshop.ui.component

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.data.model.SliderItem
import com.example.onlineshop.ui.theme.LightOrange
import com.example.onlineshop.ui.theme.Orange2
import com.example.onlineshop.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun CustomSlider(
    items: List<SliderItem>,

    delayTime: Long = 3000L,
    onItemClick: ((String) -> Unit)? = null
) {
    val pageCount = Int.MAX_VALUE
    val startIndex = pageCount / 2

    val pagerState = rememberPagerState(initialPage = startIndex, pageCount = { pageCount })



    LaunchedEffect(Unit) {
        while (true) {
            delay(delayTime)
            pagerState.animateScrollToPage(
                pagerState.currentPage + 1,
                animationSpec = tween(durationMillis = 800, easing = LinearOutSlowInEasing)
            )

        }

    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,

            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)


        ) { page ->
            val item = items[page % items.size]

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp, vertical = 20.dp)

            ) {


                val backgroundGradient = Brush.linearGradient(
                    colors = listOf(
                        item.backgroundStart, item.backgroundEnd
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(200f, 0f)

                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()


                            .background(backgroundGradient)
                            .clickable {
                                onItemClick?.invoke(item.title)
                            }, contentAlignment = Alignment.Center
                    ) {


                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier


                                    .width(181.dp),

                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End


                            ) {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth(),

                                    text = item.title,
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(textDirection = TextDirection.Rtl)


                                )
                                SpacerHeight(5)
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 5.dp),
                                    text = item.text,
                                    color = Color.White,
                                    fontSize = 13.sp,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 15.sp


                                )
                            }
                            val circleGradient = Brush.radialGradient(
                                colors = listOf(
                                    item.circleCenter,
                                    item.circleEdge
                                )
                            )

                            Box(
                                modifier = Modifier
                                    .size(130.dp)
                                    .background(circleGradient, shape = CircleShape),
                                contentAlignment = Alignment.Center


                            ) {
                                Image(
                                    painter = painterResource(item.imageRes),
                                    contentDescription = item.title,
                                    contentScale = ContentScale.Fit,
                                    modifier = (item.modifier ?: Modifier)


                                )
                            }
                        }


                    }


                }
                if (item.takhfif == true) {
                    Box(
                        modifier = Modifier


                            .align(Alignment.TopStart)
                            .offset(x = (11).dp, y = (-9).dp)


                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(LightOrange, Orange2),
                                    start = Offset(0f, 0f),
                                    end = Offset(200f, 0f)
                                ), shape = RoundedCornerShape(30.dp)
                            )

                            .height(22.dp)
                            .width(70.dp),


                        contentAlignment = Alignment.Center

                    ) {
                        Text(
                            text = "تخفیف ویژه",
                            textAlign = TextAlign.Center,
                            color = White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }


            }


        }


    }


}
