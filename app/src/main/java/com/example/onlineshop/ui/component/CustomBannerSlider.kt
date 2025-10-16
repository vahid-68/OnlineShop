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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.data.model.BannerItemModel
import com.example.onlineshop.ui.theme.LightOrange
import com.example.onlineshop.ui.theme.Orange2
import com.example.onlineshop.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun CustomBannerSlider(
    banners: List<BannerItemModel>,
    modifier: Modifier = Modifier,



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

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
    ) {
        HorizontalPager(
            state = pagerState,



            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)


        ) { page ->
           val index = page % banners.size


            CustomBannerCard(
                item = banners[index],
                modifier = Modifier
                    .padding(horizontal = 8.dp)


            )

        }
                Row (
                    modifier= Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 18.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    banners.forEachIndexed { i,_  ->

                        val isSelected=(pagerState.currentPage % banners.size)==i

                        Box(
                            modifier = Modifier
                                .padding(horizontal = 3.dp)
                                .size(
                                    if (isSelected)7.dp else 6.dp
                                )
                                .clip(CircleShape)
                                .background(
                                    if (isSelected)White else White.copy(alpha = 0.4f)
                                )
                        )
                    }
                }

            }



        }




