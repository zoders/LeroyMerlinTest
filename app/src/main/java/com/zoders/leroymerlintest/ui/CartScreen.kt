package com.zoders.leroymerlintest.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zoders.leroymerlintest.R
import com.zoders.leroymerlintest.data.cart.Cart
import com.zoders.leroymerlintest.ui.components.PartialDivider
import com.zoders.leroymerlintest.ui.components.ProductItem
import com.zoders.leroymerlintest.ui.navigation.ScrollableAppBar
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavHostController

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MainPageViewModel
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {

            Text(
                text = "Корзина",
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.black),
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 5.dp)
            )
            var sum = 0
            Cart.getCart().forEach {
                sum += it.price
            }
            Text(text = "Итого: $sum ₽", color = Color.Black, modifier = Modifier
                .padding(bottom = 60.dp, start = 5.dp)
            )
            LazyColumn(
                modifier = modifier
            ) {

                items(Cart.getCart().toList()) { item ->
                    ProductItem(item, navController, viewModel)
                    PartialDivider(
                        weightLeft = 1f,
                        weightRight = 2f,
                        color = Color(238, 239, 240)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    //CartScreen()
}
