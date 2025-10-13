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
import androidx.compose.ui.unit.dp
import com.example.onlineshop.data.model.CategoryCardItem
import com.example.onlineshop.ui.theme.White


@Composable
fun CustomCategoryCard(
    item: CategoryCardItem,


    onClick: () -> Unit,

    ) {
    Card(
        modifier = Modifier

            .height(115.dp)
            .width(100.dp),
        onClick = onClick,
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