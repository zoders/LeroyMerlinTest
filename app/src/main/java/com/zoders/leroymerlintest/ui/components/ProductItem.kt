package com.zoders.leroymerlintest.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.zoders.leroymerlintest.data.ProductsPictures
import com.zoders.leroymerlintest.data.db.Product
import com.zoders.leroymerlintest.ui.MainPageViewModel
import com.zoders.leroymerlintest.ui.navigation.NavigationItem

private fun mToast(context: Context, text: String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

@Composable
fun ProductItem(product: Product, navController: NavHostController, viewModel: MainPageViewModel) {
    val mContext = LocalContext.current
    Row(
        Modifier.clickable(
            onClick = {

                //mToast(mContext, product.productId.toString())
                navController.navigate(NavigationItem.ProductPage.route + "/${product.productId}") {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }



            }
        )
    ) {
        Image(
            painter = painterResource(
                id = ProductsPictures.getDrawableById(product.productId)
            ),
            contentDescription = null,
            Modifier
                .weight(1f)
                .padding()

        )
        ProductInfoCard(
            product = product,
            modifier = Modifier
                //.height(150.dp)
                .weight(2f),
            viewModel
        )
    }
}