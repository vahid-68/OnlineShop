package com.example.onlineshop.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp


@Composable
fun MainLogo(
    image:Int,

    imageSize: Dp,

    modifier: Modifier,



) {



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier

    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "imageLogo",
            modifier = modifier


                .size(imageSize)
        )





    }

}
