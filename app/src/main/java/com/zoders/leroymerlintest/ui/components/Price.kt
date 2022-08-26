package com.zoders.leroymerlintest.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zoders.leroymerlintest.R
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Price(price: Int, modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(verticalAlignment = Alignment.Bottom) {
            val stringPrice: String = if (price > 999) {
                val leftPart = price / 1000
                when (val rightPart = price % 1000) {
                    0 -> {
                        "$leftPart 000"
                    }
                    in 10..99 -> {
                        "$leftPart 0$rightPart"
                    }
                    in 1..9 -> {
                        "$leftPart 00$rightPart"
                    }
                    else -> {
                        "$leftPart $rightPart"
                    }
                }
            } else {
                price.toString()
            }
            Text(
                text = stringPrice,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.black)
            )
            Text(
                text = "₽ / шт.",
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.black),
                modifier = Modifier.padding(start = 5.dp),
                fontSize = 15.sp
            )
        }
        // Credit or smth like this
        Text(
            text = "77 ₽ / шт.",
            color = Color.Gray,
            modifier = Modifier.padding(start = 5.dp),
            fontSize = 15.sp
        )
    }
}