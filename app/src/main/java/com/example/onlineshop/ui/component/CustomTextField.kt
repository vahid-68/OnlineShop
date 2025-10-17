package com.example.onlineshop.ui.component

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlineshop.ui.theme.GrayLight
import com.example.onlineshop.ui.theme.White
import com.example.onlineshop.R

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit ,
    direction: TextDirection = TextDirection.Ltr,
    placeholder: String,
    trailingIcon:@Composable (() -> Unit)?=null,

    type: KeyboardType = KeyboardType.Text,
    modifier: Modifier= Modifier,
    horizontalPadding: Dp =16.dp



    ){

    TextField(
        value = value,
        onValueChange =onValueChange,


        shape = RoundedCornerShape(11.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal =horizontalPadding),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = White,
            unfocusedContainerColor = White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(
            textDirection = direction,
        ),
        placeholder = {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = placeholder,
                fontSize = 12.sp,
                color = GrayLight,
                style = TextStyle(
                    textDirection = direction
                )

            )
        },
        trailingIcon=trailingIcon,
        keyboardOptions = KeyboardOptions(
            keyboardType = type
        )

    )
}


