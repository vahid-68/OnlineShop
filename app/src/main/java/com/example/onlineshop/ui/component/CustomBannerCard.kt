package com.example.onlineshop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.onlineshop.data.model.BannerItemModel
import com.example.onlineshop.ui.theme.Green1
import com.example.onlineshop.ui.theme.Green2
import com.example.onlineshop.ui.theme.Green3
import com.example.onlineshop.ui.theme.Green4
import com.example.onlineshop.ui.theme.LightOrange
import com.example.onlineshop.ui.theme.Orange2
import com.example.onlineshop.ui.theme.White
import com.example.onlineshop.ui.utils.responsiveFontSize

@Composable
fun CustomBannerCard(
    item: BannerItemModel,
    modifier: Modifier = Modifier,


    onBannerClick: (() -> Unit)? = null


) {
    val bgColors = item.bgGradient ?: listOf(Green1, Green2)

    val circleColors = item.circleGradient ?: listOf(Green3, Green4)

    val widthModifire = if (item.cardWidth != null)
        Modifier.width(item.cardWidth) else
        Modifier.fillMaxWidth()

    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Card(

            modifier = modifier
                .then(widthModifire)
                .height(item.cardHeight),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = { onBannerClick?.invoke() }
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = bgColors
                        )
                    ),
                contentAlignment = Alignment.Center


            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Column(
                        modifier = Modifier


                            .width(150.dp),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End


                    ) {
                        item.title?.let {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),

                                text = it,
                                color = Color.White,
                                fontSize = responsiveFontSize(19.sp,17.sp,20.sp, xlarge = 22.sp),
                                fontWeight = FontWeight.ExtraBold,
                                textAlign = TextAlign.Center,
                                style = TextStyle(textDirection = TextDirection.Rtl)


                            )
                        }
                        SpacerHeight(5)
                        item.text?.let {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 5.dp),
                                text = it,
                                color = Color.White,
                                fontSize = responsiveFontSize(15.sp,12.sp,16.sp, xlarge = 18.sp),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                lineHeight = 19.sp


                            )
                        }

                    }

                    Box(
                        modifier = Modifier

                            .size(140.dp)
                            .clip(CircleShape)

                            .background(
                                brush = Brush.radialGradient(
                                    colors = circleColors,

                                    )
                            ),
                        contentAlignment = Alignment.Center

                    ) {
                        Image(
                            painter = painterResource(item.imageRes),
                            contentDescription = item.title,

                            modifier = Modifier
                                .size(item.imageSize)
                                .padding(bottom = 10.dp),
                            contentScale = ContentScale.Fit,
                        )
                    }


                }


            }


        }

        if (item.discount == true) {
            CustomDiscoundBadge(
                text = "تخفیف ویژه",
                isPercentType = false,
                halfOutsides = true,
                modifier = Modifier
                    .width(65.dp)
                    .height(22.dp)

            )
        }


    }


}
