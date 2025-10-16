package com.example.onlineshop.data.model


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.ui.theme.White

data class CategoryItemModel(
    val imageRes: Int,
    val title: String?=null,
    val description: String?=null,
    val cardHeight: Dp=83.dp,
    val cardWidth: Dp=70.dp,
val imageSize: Dp?=null,
    val titleSize: TextUnit?=null,



)
