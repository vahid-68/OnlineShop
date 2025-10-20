package com.example.onlineshop.ui.component

import android.annotation.SuppressLint
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.data.model.ProductItemModel
import com.example.onlineshop.ui.theme.BgProduct
import com.example.onlineshop.ui.theme.GrayBlack
import com.example.onlineshop.ui.theme.White
import com.example.onlineshop.R
import com.example.onlineshop.ui.theme.LightOrange
import com.example.onlineshop.ui.theme.Orange2

import com.example.onlineshop.ui.utils.responsiveFontSize


@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun CustomProductCard(
    item: ProductItemModel,
    modifier: Modifier = Modifier,


    onClick: (() -> Unit)? = null,

    ) {
    val imageRes = item.imageRes
    val price = item.price
    val priceWithDiscount = item.priceWithDiscount ?: String()
    val title = item.title

    val cardWidth = item.cardWidth
    val cardHeight = item.cardHeight
    val imageSize = item.imageSize ?: 80.dp

    val discount: Boolean = item.discount ?: false






    Box() {

        Card(
            modifier = modifier
                .height(cardHeight)


                .width(cardWidth),


            onClick = { onClick?.invoke() },
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = BgProduct
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = title,
                    modifier = Modifier
                        .size(imageSize)
                )

                Box(
                ) {

                    Card(
                        modifier = modifier

                            .height(80.dp)
                            .width(170.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.3.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = White
                        ),

                        ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(top = 9.dp),
                                text = title,
                                fontSize = responsiveFontSize(14.sp,12.sp,14.sp, xlarge = 16.sp),
                                fontWeight = FontWeight.Bold,
                                style = TextStyle(letterSpacing = (-0.5).sp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 20.dp),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                  horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically

                                    ) {
                                    Text(

                                        text = "تومان",
                                        fontSize = 11.sp,
                                        color = GrayBlack

                                    )
                                    Text(

                                        text = price,
                                        fontSize = responsiveFontSize(12.sp,10.sp,13.sp, xlarge = 14.sp),
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.labelSmall

                                    )
                                }

                                Box(
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Text(
                                        text = priceWithDiscount,
                                        fontSize = responsiveFontSize(11.sp,9.sp,12.sp, xlarge = 14.sp),
                                        style = MaterialTheme.typography.labelSmall,
                                        color = GrayBlack,


                                        )
                                    Icon(
                                        painter = painterResource(R.drawable.ic_line_discount),
                                        contentDescription = "lineDiscount",
                                        tint = GrayBlack,
                                        modifier = Modifier
                                            .size(40.dp)
                                    )
                                }

                            }

                        }


                    }


                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .align(Alignment.CenterStart)
                            .offset(x = (-15).dp)
                            .background(
                                brush = Brush.linearGradient(
                                    listOf(LightOrange, Orange2)
                                ),
                                shape = CircleShape
                            )


                            .clickable(
                            ) {


                            },


                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "add",
                            tint = White,
                            modifier = Modifier
                                .size(18.dp),

                            )
                    }



                    if (discount){
                        CustomDiscoundBadge(
                            text = "10",
                            isPercentType = true,
                            halfOutsides = false,
                            modifier = Modifier

                                .width(100.dp)
                                .height(25.dp)
                                .offset(x = (150).dp, y = (-150).dp)





                        )
                    }


                }


            }

        }


    }

}





