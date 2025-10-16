package com.example.onlineshop.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.onlineshop.data.model.CategoryItemModel

@Composable
fun CustomCategorySlider(
    categories: List<CategoryItemModel>,

    onCategoryClick: ((CategoryItemModel) -> Unit)? = null
) {

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
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