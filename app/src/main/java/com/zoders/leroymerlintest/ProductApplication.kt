package com.zoders.leroymerlintest

import android.app.Application
import com.zoders.leroymerlintest.data.db.ProductDatabase
import com.zoders.leroymerlintest.data.db.ProductRepository

class ProductApplication: Application() {
    private val database by lazy { ProductDatabase.getDatabase(this) }
    val repository by lazy { ProductRepository(database.productDao()) }
}