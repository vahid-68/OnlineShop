package com.example.onlineshop.ui.component

import android.R
import android.R.attr.text
import android.graphics.drawable.Icon
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.onlineshop.data.model.BottomNavItem
import com.example.onlineshop.ui.theme.GrayBlack
import com.example.onlineshop.ui.theme.Orange2
import com.example.onlineshop.ui.theme.White
import com.example.onlineshop.ui.utils.responsiveFontSize

@Composable

fun CustomBottomBar(
    items: List<BottomNavItem>,
    selectedIndex: Int,
    onItemClick: (Int) -> Unit,
) {


    NavigationBar(
        containerColor = White,
        tonalElevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()

            .height(75.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)

        ) {
            items.forEachIndexed { index, item ->

                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = { onItemClick(index) },


                    icon = {
                        Box(
                            modifier = Modifier


                                .padding(top = 4.dp)


                        ) {

                            if (selectedIndex == index) {
                                Box(
                                    modifier = Modifier
                                        .offset(y = (-14).dp)

                                        .align(Alignment.TopCenter)
                                        .width(28.dp)
                                        .height(4.dp)

                                        .background(Orange2, shape = RoundedCornerShape(3.dp))

                                )
                            }





                            Image(
                                painter = painterResource(id = item.iconRes),
                                contentDescription = item.title,
                                modifier = Modifier
                                    .size(25.dp)
                                    .align(Alignment.Center)

                            )
                        }
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = responsiveFontSize(14.sp,12.sp,14.sp, xlarge = 16.sp),
                            color = if (selectedIndex == index) Orange2 else GrayBlack

                        )
                    },


                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent,


                        )
                )

            }
        }
    }

}



