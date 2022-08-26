package com.zoders.leroymerlintest.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RatingBar(rating: Float, reviews: Int, modifier: Modifier = Modifier) {
    Row(modifier) {
        StarRating(rating)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "($reviews)", fontSize=12.sp, color = Color.Gray)
    }
}