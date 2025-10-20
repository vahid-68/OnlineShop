package com.example.onlineshop.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.ui.utils.responsiveFontSize

@Composable
fun DropdownMenuItem(imageRes: Int, text: String, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 6.dp, horizontal = 4.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = responsiveFontSize(14.sp,12.sp,14.sp, xlarge = 16.sp),
            modifier = Modifier.padding(start = 10.dp),
            textAlign = TextAlign.Right
        )
        SpacerWidth(10)
        androidx.compose.foundation.Image(
            painter = painterResource(imageRes),
            contentDescription = text,
            modifier = Modifier
                .size(20.dp)
        )

    }
}