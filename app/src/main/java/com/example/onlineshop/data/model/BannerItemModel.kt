package com.example.onlineshop.data.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class BannerItemModel(
    val imageRes: Int,
    val title: String?=null,
    val text: String?=null,

    val description: String?=null,
    val bgGradient: List<Color>?=null,
    val circleGradient: List<Color>?=null,
    val cardHeight: Dp=160.dp,
    val cardWidth: Dp?=null,
    val imageSize: Dp=130.dp,
    val titleFontSize: TextUnit=18.sp,
    val textFontSize: TextUnit=14.sp,
    val discount: Boolean?=null


    )
