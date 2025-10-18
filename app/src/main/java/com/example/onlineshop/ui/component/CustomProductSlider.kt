package com.example.onlineshop.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.onlineshop.data.model.ProductItemModel

@Composable
fun CustomProductSlider(
    products :List<ProductItemModel>,
    onProductClick: ((ProductItemModel) -> Unit)? = null
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp),
            reverseLayout = true
        ) {
            items(products) { item ->
                CustomProductCard(
                    item = item,


                    onClick = {
                        onProductClick?.invoke(item)
                    }
                )

            }
        }


    }

}
