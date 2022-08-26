package com.zoders.leroymerlintest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zoders.leroymerlintest.data.db.Product
import com.zoders.leroymerlintest.ui.navigation.ScrollableAppBar
import com.zoders.leroymerlintest.ui.components.PartialDivider
import com.zoders.leroymerlintest.ui.components.ProductItem

@Composable
fun MainPageScreen(
    viewModel: MainPageViewModel,
    modifier: Modifier = Modifier,
    scrollState: LazyListState,
    navController: NavHostController,
    productList: List<Product>
) {
    viewModel.updateScrollPosition(scrollState.firstVisibleItemIndex)
    val scrollUpState: State<Boolean?> = viewModel.scrollUp.observeAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(top = 160.dp),
            state = scrollState
        ) {

            items(productList) { item ->
                ProductItem(item, navController, viewModel)
                PartialDivider(
                    weightLeft = 1f,
                    weightRight = 2f,
                    color = Color(238, 239, 240)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        ScrollableAppBar(scrollUpState = scrollUpState)
    }


}
@Preview(showBackground = true)
@Composable
fun MainPageScreenPreview() {
    //MainPageScreen()
}