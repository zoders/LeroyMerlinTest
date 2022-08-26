package com.zoders.leroymerlintest.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.zoders.leroymerlintest.R
import com.zoders.leroymerlintest.data.db.Product
import com.zoders.leroymerlintest.ui.CartScreen
import com.zoders.leroymerlintest.ui.MainPageScreen
import com.zoders.leroymerlintest.ui.MainPageViewModel
import com.zoders.leroymerlintest.ui.ProductScreen
import com.zoders.leroymerlintest.ui.components.Indicator

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Main,
        NavigationItem.Cart
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = colorResource(id = R.color.black)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            var isCart = false
            var indicate = 0
            if (item.route == "cart") {
                isCart = true
                indicate = 1
            }
            BottomNavigationItem(

                icon = {
                    /*Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title
                    )*/
                       Indicator(navigationItem = item/*, number = indicate*/)
                },
                label = { Text(text = item.title) },
                selectedContentColor = Color(83, 196, 63),
                unselectedContentColor = colorResource(id = R.color.black).copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
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
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    //BottomNavigationBar()
}

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: MainPageViewModel,
    scrollState: LazyListState,
    products: List<Product>
) {
    NavHost(navController, startDestination = NavigationItem.Main.route) {
        composable(NavigationItem.Main.route) {
            MainPageScreen(viewModel, modifier = Modifier.fillMaxSize(), scrollState, navController, products)
        }
        composable(NavigationItem.Cart.route) {
            CartScreen(modifier = Modifier.fillMaxSize(), navController,viewModel)
        }
        composable("${NavigationItem.ProductPage.route}/{id}") { backStackEntry ->
            ProductScreen(backStackEntry.arguments?.getString("id")!!, products, viewModel)
        }

    }
}