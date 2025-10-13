package com.example.onlineshop.data.model

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

data class BannerSliderModel(
    val imageRes: Int,
    val title: String,
    val text: String,
    val description: String,
    val backgroundStart: Color,
    val backgroundEnd: Color,
    val circleCenter:Color,
    val circleEdge: Color,
    val modifier: Modifier?=null,
    val discount: Boolean?=null


    )
