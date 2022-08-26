package com.zoders.leroymerlintest.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.zoders.leroymerlintest.R
import com.zoders.leroymerlintest.data.db.Product
import com.zoders.leroymerlintest.ui.navigation.BottomNavigationBar
import com.zoders.leroymerlintest.ui.navigation.Navigation

@Composable
fun LeroyMerlinTestApp(viewModel: MainPageViewModel, products: List<Product>) {
    val navController = rememberNavController()
    val scrollState = rememberLazyListState()
    Scaffold(
        topBar =
        {
            TopBar(viewModel, scrollState)
        },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController, viewModel, scrollState, products)
            }
        },
        backgroundColor = colorResource(id = R.color.white)
    )
}

@Preview(showBackground = true)
@Composable
fun LeroyMerlinTestAppPreview() {
    //LeroyMerlinTestApp(viewModel = MainPageViewModel())
}

@Composable
fun TopBar(viewModel: MainPageViewModel, scrollState: LazyListState) {
    viewModel.updateScrollPosition(scrollState.firstVisibleItemIndex)
    val scrollUpState: State<Boolean?> = viewModel.scrollUp.observeAsState()
    val elevation by animateDpAsState(if (scrollUpState.value == true) 1.dp else 0.dp)
    TopAppBar(
        title = { Text(text = "Шпаклевки", fontWeight = FontWeight.SemiBold, fontSize = 18.sp) },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = elevation
    )
}