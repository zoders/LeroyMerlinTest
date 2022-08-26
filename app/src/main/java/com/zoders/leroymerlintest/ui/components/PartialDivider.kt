package com.zoders.leroymerlintest.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PartialDivider(weightLeft: Float, weightRight: Float, color: Color) {
    Row()
    {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(weightLeft),
            color = Color.Transparent
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(weightRight),
            color = color
        )
    }
}