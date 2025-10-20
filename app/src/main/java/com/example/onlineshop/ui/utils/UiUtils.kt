package com.example.onlineshop.ui.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.TextUnit

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun responsiveFontSize(
small: TextUnit,
medium: TextUnit,
large: TextUnit,
xlarge: TextUnit

): TextUnit{
    val screenWidth= LocalConfiguration.current.screenWidthDp
    return  when{
        screenWidth < 380 -> small
        screenWidth < 400 -> medium
        screenWidth < 450 -> large
        else -> xlarge
    }
}