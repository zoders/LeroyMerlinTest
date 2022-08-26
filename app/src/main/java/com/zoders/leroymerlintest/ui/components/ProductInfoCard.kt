package com.zoders.leroymerlintest.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zoders.leroymerlintest.R
import com.zoders.leroymerlintest.data.cart.Cart
//import com.zoders.leroymerlintest.data.Cart
import com.zoders.leroymerlintest.data.db.Product
import com.zoders.leroymerlintest.data.wishlist.Wishlist
import com.zoders.leroymerlintest.ui.MainPageViewModel

private fun mToast(context: Context, text: String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

@Composable
fun ProductInfoCard(
    product: Product,
    modifier: Modifier = Modifier,
    viewModel: MainPageViewModel
) {
    val mContext = LocalContext.current
    Column(modifier) {
        Column {
            Text(
                product.productName, color = colorResource(id = R.color.black),
                maxLines = 3,
                modifier = Modifier.padding(end = 5.dp)

            )
            RatingBar(
                rating = product.rating,
                product.reviews,
                modifier = Modifier.padding(top = 5.dp)
            )
            Price(
                price = product.price,
                modifier = Modifier.padding(top = 10.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp, end = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
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
                        //mToast(mContext, Cart.size().toString())
                    })
                }

                if (Cart.cont(product)) {
                    color.value = Color.Green
                    text.value = "Удалить"
                    onClick.value = {
                        text.value = "В корзину"
                        color.value = Color(red = 232, green = 233, 235)
                        viewModel.removeCartItem(product)
                        //mToast(mContext, Cart.size().toString())
                    }
                } else {
                    color.value = Color(red = 232, green = 233, 235)
                    text.value = "В корзину"
                    onClick.value = {
                        text.value = "Удалить"
                        color.value = Color.Green
                        viewModel.addCartItem(product)
                        //mToast(mContext, Cart.size().toString())
                    }
                }


                Button(
                    colors = buttonColors(color.value),
                    elevation = elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 3.dp
                    ),
                    modifier = Modifier
                        .height(50.dp),
                    onClick = onClick.value
                ) {
                    Text(

                        text = text.value,
                        color = Color.Black
                    )

                }
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
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProductInfoCardPreview() {
    val product = Product(
        0,
        "Шпаклёвка готовая финишная Danogips SuperFinish 18.1 кг",
        10999,
        0f,
        62,1,1
    )
    //ProductInfoCard(product, viewModel = )
}
