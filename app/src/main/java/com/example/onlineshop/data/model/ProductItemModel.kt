package com.example.onlineshop.data.model

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ProductItemModel(
    val imageRes: Int,
    val title: String,
    val price: String,
    val priceWithDiscount: String?=null,
    val discount: Boolean?=null,
    val description: String?=null,
    val cardHeight: Dp=260.dp,
    val cardWidth: Dp=200.dp,
    val imageSize: Dp?=140.dp,



    )
