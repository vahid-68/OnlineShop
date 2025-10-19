package com.example.onlineshop.ui.component

import android.R
import android.R.attr.text
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.data.model.BottomNavItem
import com.example.onlineshop.ui.theme.GrayBlack
import com.example.onlineshop.ui.theme.Orange2
import com.example.onlineshop.ui.theme.White

@Composable

fun CustomBottomBar(
    items: List<BottomNavItem>,
    selectedItem: String,
    onItemClick: (String) -> Unit,
) {



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(vertical = 4.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items.forEach { item ->
            val isSelected = item.title == selectedItem

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onItemClick(item.title) },
                contentAlignment = Alignment.Center
            ) {

                Column(
                    modifier = Modifier,

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .offset(y = (-4).dp)

                            .align(Alignment.CenterHorizontally)
                                .width(24.dp)
                                .height(3.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Orange2)

                        )
                    } else {
                        SpacerHeight(3)
                    }
SpacerHeight(8)

                    Image(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.title,
                        modifier = Modifier
                            .size(25.dp),

                        )
                    SpacerHeight(2)
                    Text(

                        text = item.title,
                        fontSize = 12.sp,
                        color = if (isSelected) Orange2 else GrayBlack


                    )


                }

            }

        }
    }



}

