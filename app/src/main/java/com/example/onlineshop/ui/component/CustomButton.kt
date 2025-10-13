package com.example.onlineshop.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.onlineshop.ui.theme.Btn1
import com.example.onlineshop.ui.theme.Btn2

@Composable
fun CustomButton(
    text: String,
    onClick:() -> Unit
){
    Button({
        onClick()
    },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp)
            .background(
                Brush.linearGradient(
                    listOf(Btn1, Btn2)
                ),
                shape = RoundedCornerShape(11.dp)
            )

        ,


        shape = RoundedCornerShape(11.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Text(
            text = text,
        )
    }

}

