package com.example.onlineshop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.onlineshop.R
import com.example.onlineshop.data.model.CategoryItem
import com.example.onlineshop.ui.theme.White


@Composable
fun CustomCategoryItem(
    item: CategoryItem,
    modifier: Modifier= Modifier
){
    Card(
        modifier = Modifier

            .height(115.dp)
            .width(100.dp)
            .background(White, shape = RoundedCornerShape(16.dp))
            ,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        )
    ) {

        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly

        ){
            Image(
                painter = painterResource(item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .size(55.dp)
                    .padding(top = 8.dp)
            )
            Text(
                text = item.title,
                fontWeight = FontWeight.Bold

            )
        }
    }
}