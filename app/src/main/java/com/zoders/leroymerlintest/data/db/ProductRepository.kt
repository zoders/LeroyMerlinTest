package com.zoders.leroymerlintest.data.db

import kotlinx.coroutines.flow.Flow

class ProductRepository (private val productDao: ProductDao) {
    val allProducts: Flow<List<Product>> = productDao.readAll()
}
