package com.zoders.leroymerlintest.data.cart

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.zoders.leroymerlintest.data.db.Product

object Cart {
    private val cart = mutableSetOf<Product>()

    fun getCart() = cart

    fun addToCart(product: Product) {
        cart.add(product)
    }

    fun removeFromCart(product: Product) {
        cart.remove(product)
    }
    fun cont(product: Product) = product in cart
}