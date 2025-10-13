package com.example.onlineshop.ui.component

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.onlineshop.R
import com.example.onlineshop.ui.theme.White


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderApp(
    menuExpanded: Boolean,
    onMenuClick: () -> Unit
) {

    val rotation by animateFloatAsState(
        targetValue = if (menuExpanded) 180f else 0f,
        animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
    )
    Column {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .height(100.dp),
            title = {},
            actions = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_profile),
                        contentDescription = "profile",
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(30.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.FillBounds

                    )
                    Box() {
                        Icon(
                            Icons.Default.NotificationsNone,
                            contentDescription = "notifications"
                        )
                        Box(
                            modifier = Modifier
                                .padding(top = 4.dp, end = 3.dp)
                                .size(8.dp)
                                .background(color = Color.Red, shape = CircleShape)
                                .align(Alignment.TopEnd)

                        ) {

                        }
                    }
                    IconButton(onClick = onMenuClick) {
                        Icon(
                            if (menuExpanded)
                                Icons.Default.Close else Icons.Default.Menu,
                            if (menuExpanded) "close menu" else {
                                "open menu"
                            },
                            modifier = Modifier
                                .size(28.dp)
                                .rotate(rotation)
                        )
                    }
                }
            },
            navigationIcon = {

                Row(
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier

                    ) {
                        MainLogo(
                            image = R.drawable.ic_logo,

                            imageSize = 35.dp,

                            modifier = Modifier
                                .offset(x = (-8).dp),

                            )

                        OnlineShopLogo(

                            image = R.drawable.online_shop,
                            imageSize = 70.dp,

                            modifier = Modifier
                                .offset(x = (-8).dp),


                            )
                    }
                }

            }
        )
    }


}
