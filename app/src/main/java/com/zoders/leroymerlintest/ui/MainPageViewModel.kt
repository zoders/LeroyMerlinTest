package com.zoders.leroymerlintest.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.*
import com.zoders.leroymerlintest.data.cart.Cart
import com.zoders.leroymerlintest.data.db.Product
import com.zoders.leroymerlintest.data.db.ProductDatabase
import com.zoders.leroymerlintest.data.db.ProductRepository
import com.zoders.leroymerlintest.data.wishlist.Wishlist
import com.zoders.leroymerlintest.ui.navigation.NavigationItem
import kotlinx.coroutines.launch

class MainPageViewModel(private val repository: ProductRepository) : ViewModel() {

    val allProducts: LiveData<List<Product>> = repository.allProducts.asLiveData()

    fun addCartItem(item: Product) {
        viewModelScope.launch {
            Cart.addToCart(item)
        }
    }
    fun removeCartItem(item: Product) {
        viewModelScope.launch {
            Cart.removeFromCart(item)
        }
    }

    fun addWishlistItem(item: Product) {
        viewModelScope.launch {
            Wishlist.addToWishlist(item)
        }
    }

    fun removeWishlistItem(item: Product) {
        viewModelScope.launch {
            Wishlist.removeFromWishlist(item)
        }
    }

    private var lastScrollIndex = 0
    private val _scrollUp = MutableLiveData(false)
    val scrollUp: LiveData<Boolean>
        get() = _scrollUp

    fun updateScrollPosition(newScrollIndex: Int) {
        if (newScrollIndex == lastScrollIndex) return

        _scrollUp.value = newScrollIndex > lastScrollIndex
        lastScrollIndex = newScrollIndex
    }
}



class MainPageViewModelFactory(private val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainPageViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return (MainPageViewModel(repository) as T)
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}