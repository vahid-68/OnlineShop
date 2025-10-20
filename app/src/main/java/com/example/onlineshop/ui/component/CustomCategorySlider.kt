package com.example.onlineshop.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.onlineshop.data.model.CategoryItemModel

@Composable
fun CustomCategorySlider(
    categories: List<CategoryItemModel>,

    onCategoryClick: ((CategoryItemModel) -> Unit)? = null
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            reverseLayout = true
        ) {
            items(categories) { item ->
                CustomCategoryCard(
                    item = item,

                    onClick = {
                        onCategoryClick?.invoke(item)
                    }

                )

            }
        }

    }

}