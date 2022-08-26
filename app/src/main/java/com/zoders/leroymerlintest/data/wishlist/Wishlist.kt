package com.zoders.leroymerlintest.data.wishlist

import com.zoders.leroymerlintest.data.db.Product

object Wishlist {
    private val wishlist = mutableSetOf<Product>()

    //fun getCart() = cart

    fun addToWishlist(product: Product) {
        wishlist.add(product)
    }

    fun removeFromWishlist(product: Product) {
        wishlist.remove(product)
    }
    fun cont(product: Product) = product in wishlist
}