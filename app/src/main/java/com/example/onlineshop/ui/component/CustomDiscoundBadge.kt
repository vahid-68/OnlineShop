package com.example.onlineshop.ui.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.ui.theme.LightOrange
import com.example.onlineshop.ui.theme.Orange
import com.example.onlineshop.ui.theme.Orange2
import com.example.onlineshop.ui.theme.White
import com.example.onlineshop.ui.utils.responsiveFontSize

@Composable
fun CustomDiscoundBadge(
    text: String,
    modifier: Modifier = Modifier,
    isPercentType: Boolean = false,
    halfOutsides: Boolean = false,
    gradientColors: List<Color> = listOf(LightOrange,Orange2),

    ){
    Box(
        modifier = modifier
            .then(if (halfOutsides) Modifier.offset(x = (20).dp, y = (-8).dp) else Modifier)
            .background(
                brush = Brush.linearGradient(colors = gradientColors),
                shape = RoundedCornerShape(14.dp)
            ),
        contentAlignment = if (isPercentType) Alignment.CenterStart else Alignment.Center



    ){
        Text(
            text=if (isPercentType) "$text%" else text,
            color = White,
            fontSize = responsiveFontSize(12.sp,10.sp,12.sp, xlarge = 14.sp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = if (isPercentType) 6.dp else 0.dp)



        )
    }

}