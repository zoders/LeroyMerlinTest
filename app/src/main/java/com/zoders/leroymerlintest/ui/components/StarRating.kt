package com.zoders.leroymerlintest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zoders.leroymerlintest.R

@Composable
fun StarRating(rating: Float) {
    Row {
        var emptyStars = 5
        val width = 6.dp
        val integerRating = rating.toInt()
        val fractionalPart = rating - integerRating.toFloat()
        repeat(integerRating) {
            Image(painter = painterResource(id = R.drawable.star), contentDescription = null)
            emptyStars--
            Spacer(modifier = Modifier.width(width))
        }
        if (fractionalPart >= 0.5f) {
            Image(painter = painterResource(id = R.drawable.halfstar), contentDescription = null)
            emptyStars--
            Spacer(modifier = Modifier.width(width))
        }
        repeat(emptyStars) {
            Image(painter = painterResource(id = R.drawable.emptystar), contentDescription = null)
            Spacer(modifier = Modifier.width(width))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StarRatingPreview() {
    StarRating(rating = 2.5f)
}