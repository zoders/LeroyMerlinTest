package com.zoders.leroymerlintest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zoders.leroymerlintest.data.Category

@Composable
fun CategoryItem(category: Category, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(80.dp)
                .width(180.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(Color(242, 243, 245))
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(
                    id = category.drawableId
                ),
                contentDescription = null,
                modifier = Modifier.padding(5.dp)
            )
            Text(text = category.title, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    CategoryItem(Category.CATEGORY1)
}