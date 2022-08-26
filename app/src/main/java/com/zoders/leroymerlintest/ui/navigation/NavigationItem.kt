package com.zoders.leroymerlintest.ui.navigation

import com.zoders.leroymerlintest.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Main : NavigationItem("main", R.drawable.main, "Главная")
    object Cart : NavigationItem("cart", R.drawable.cart, "Корзина")
    object ProductPage : NavigationItem("product", R.drawable.halfstar, "Товар")
}

fun s() {
}