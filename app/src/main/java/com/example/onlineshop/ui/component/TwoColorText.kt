package com.example.onlineshop.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun TwoColorText(
    text1: String,
    color1: Color,
    text2: String,
    color2: Color,
    modifier: Modifier = Modifier,
    fontSize: Int,
    fontWeight: FontWeight,


    ){
    Text(



        buildAnnotatedString {
            withStyle(style = SpanStyle(color = color1)){
                append(text1)

            }

            withStyle(style = SpanStyle(color = color2)){
                append(text2)
            }
        },
        modifier = modifier
        ,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,







        )
}
