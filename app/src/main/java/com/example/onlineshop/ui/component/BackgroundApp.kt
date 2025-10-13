package com.example.onlineshop.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color


@Composable
fun BackgroundApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCF3EC)) // رنگ کرم پس‌زمینه
            .drawBehind {
                // دایره‌ی بالا سمت راست
                drawCircle(
                    color = Color(0xFFFCEDDF),
                    radius = size.width * 0.5f,
                    center = Offset(x = size.width * 1.068f, y = size.height * 0.0f)
                )

                // دایره‌ی پایین سمت چپ
                drawCircle(
                    color = Color(0xFFFCEDDF),
                    radius = size.width * 0.58f,
                    center = Offset(x = size.width * -0.10f, y = size.height * 1.0f)
                )

                // دایره‌ی وسط سمت چپ
                drawCircle(
                    color = Color(0xFFFCEDDF),
                    radius = size.width * 0.25f,
                    center = Offset(x = size.width * -0.03f, y = size.height * 0.3f)
                )
            }
    )
}


