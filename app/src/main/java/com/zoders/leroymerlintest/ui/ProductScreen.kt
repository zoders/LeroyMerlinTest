package com.zoders.leroymerlintest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zoders.leroymerlintest.R
import com.zoders.leroymerlintest.data.ProductsPictures
import com.zoders.leroymerlintest.data.cart.Cart
import com.zoders.leroymerlintest.data.db.Product
import com.zoders.leroymerlintest.data.wishlist.Wishlist
import com.zoders.leroymerlintest.ui.components.Price
import com.zoders.leroymerlintest.ui.components.RatingBar

@Composable
fun ProductScreen(
    data: String,
    products: List<Product>,
    viewModel: MainPageViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
            .padding(5.dp)
    ) {
        val product = products.find { it.productId == data.toInt() }
        Image(
            painter = painterResource(
            id = ProductsPictures.getDrawableById(product!!.productId)),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = product.productName,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.black),
                fontSize = 18.sp,
                modifier = Modifier
                    .width(360.dp)
            )
            val bookmark = remember { mutableStateOf(R.drawable.bookmark) }
            var onClickBookmark = {
                bookmark.value = R.drawable.bookmarkchecked
                viewModel.addWishlistItem(product)
            }
            if (Wishlist.cont(product)) {
                bookmark.value = R.drawable.bookmarkchecked
                onClickBookmark = {
                    bookmark.value = R.drawable.bookmark
                    viewModel.removeWishlistItem(product)
                }
            }
            Image(
                painter = painterResource(id = bookmark.value),
                contentDescription = null,
                modifier = Modifier.clickable(onClick = onClickBookmark)
            )
        }
        Box(
            modifier = Modifier
                .background(
                    color = Color.Yellow,
                    shape = RoundedCornerShape(5.dp)
                )
                .height(30.dp)
                .padding(5.dp)
        ) {
            RatingBar(rating = product.rating, reviews = product.reviews)
        }
        Row(modifier = Modifier.padding(top = 5.dp)) {
            Price(price = product.price)

            val text = remember {
                mutableStateOf("В корзину")
            }
            val color = remember {
                mutableStateOf(Color(red = 232, green = 233, 235))
            }
            val onClick = remember {
                mutableStateOf({
                    text.value = "Удалить"
                    color.value = Color.Green
                    viewModel.addCartItem(product)
                })
            }

            if (Cart.cont(product)) {
                color.value = Color.Green
                text.value = "Удалить"
                onClick.value = {
                    text.value = "В корзину"
                    color.value = Color(red = 232, green = 233, 235)
                    viewModel.removeCartItem(product)
                }
            } else {
                color.value = Color(red = 232, green = 233, 235)
                text.value = "В корзину"
                onClick.value = {
                    text.value = "Удалить"
                    color.value = Color.Green
                    viewModel.addCartItem(product)
                }
            }


            Button(
                colors = ButtonDefaults.buttonColors(color.value),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 3.dp
                ),
                modifier = Modifier
                    .height(50.dp)
                    .padding(start = 20.dp),
                onClick = onClick.value
            ) {
                Text(

                    text = text.value,
                    color = Color.Black
                )

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    //ProductScreen()
}