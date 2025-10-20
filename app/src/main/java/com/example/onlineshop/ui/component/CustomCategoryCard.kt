package com.example.onlineshop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.data.model.CategoryItemModel
import com.example.onlineshop.ui.theme.White
import com.example.onlineshop.ui.utils.responsiveFontSize


@Composable
fun CustomCategoryCard(
    item: CategoryItemModel,
    modifier: Modifier = Modifier,


    onClick: (() -> Unit)?=null,

    ) {
    val cardWidth= item.cardWidth
    val cardHeight= item.cardHeight
    val imageSize=item.imageSize?:45.dp





        Card(
            modifier = modifier
                .height(cardHeight)
                .width(cardWidth),




            onClick = { onClick?.invoke() },
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = White
            )
        ) {


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly

            ) {
                Image(
                    painter = painterResource(item.imageRes),
                    contentDescription = item.title,
                    modifier = Modifier
                        .size(imageSize)
                        .padding(top = 8.dp)
                )
                item.title?.let {
                    Text(
                        text = it,
                        fontSize = responsiveFontSize(14.sp,12.sp,22.sp, xlarge = 24.sp),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center

                    )
                }
            }
        }

}