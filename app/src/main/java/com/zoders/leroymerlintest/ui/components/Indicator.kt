package com.zoders.leroymerlintest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zoders.leroymerlintest.R
import com.zoders.leroymerlintest.ui.CartScreen
import com.zoders.leroymerlintest.ui.navigation.NavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Slider
import androidx.compose.runtime.*
//import com.zoders.leroymerlintest.data.Cart

@Composable
fun Indicator(navigationItem: NavigationItem) {
    val number = 0
    Box(contentAlignment = Alignment.TopEnd) {
        Icon(painter = painterResource(id = navigationItem.icon), contentDescription = null)
        if (navigationItem.route == "cart" && number != 0) {
            var indicate = number.toString()
            if (indicate.length > 3) {
                indicate = "∞"
            }
            Text(
                text = indicate,
                color = Color.White,
                fontSize = 9.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(25.dp))
                    .background(Color.Red)
                    .width(((indicate.length - 1) * 2).dp + 14.dp)
                    .height(14.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun IndicatorPreview() {
    /*Column {
        Indicator(indicatorEnabled = true) {
            NavigationItem.Cart()
        }
        Indicator(indicatorEnabled = true, 0)
        Indicator(indicatorEnabled = false)
        Indicator(indicatorEnabled = true, 8)
        Indicator(indicatorEnabled = true, 88)
        Indicator(indicatorEnabled = true, 888)
        Indicator(indicatorEnabled = true, 8888)
    }*/

}