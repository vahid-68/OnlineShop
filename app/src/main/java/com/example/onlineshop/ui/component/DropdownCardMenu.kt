package com.example.onlineshop.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.ExperimentalAnimatableApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.R
import com.example.onlineshop.ui.theme.Kerem
import com.example.onlineshop.ui.theme.Orange
import com.example.onlineshop.ui.theme.White

@OptIn(ExperimentalAnimatableApi::class)
@Composable
fun DropdownCardMenu(
    menuExpanded: Boolean,
    onItemClick: (String) -> Unit,

) {

    AnimatedVisibility(
        visible = menuExpanded,
        enter = expandVertically(animationSpec = tween(300)) + fadeIn(),
        exit = shrinkVertically(animationSpec = tween(300)) + fadeOut(),
        modifier = Modifier

            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Orange.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp)
                )

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(16.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Kerem, shape = RoundedCornerShape(10.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp)

                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()


                    ) {
                        Text(
                            text = "09100878747",
                            modifier = Modifier,
                            fontSize = 12.sp
                        )

                        Text(
                            text = "وحید مهدوی ",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 90.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = "profile",
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .size(30.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.FillBounds
                        )


                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    DropdownMenuItem(imageRes = R.drawable.ic_user_octagon, text = "پروفایل کاربری",
                        onClick = { onItemClick("پروفایل کاربری") })

                    DropdownMenuItem(imageRes = R.drawable.ic_task_square, text = "سفارشات من",
                        onClick = { onItemClick("سفارشات من") })

                    DropdownMenuItem(imageRes = R.drawable.ic_support, text = "پشتیبانی",
                        onClick = { onItemClick("پشتیبانی") })
                    DropdownMenuItem(imageRes = R.drawable.ic_clipboard, text = "قوانین و مقررات",
                        onClick = { onItemClick("قوانین و مقررات") })
                    DropdownMenuItem(imageRes = R.drawable.people, text = "درباره ما",
                        onClick = { onItemClick("درباره ما") })
                    DropdownMenuItem(imageRes = R.drawable.ic_music_play, text = "ارتباط با ما",
                        onClick = { onItemClick("ارتباط با ما") })


                }


            }
        }

    }
}