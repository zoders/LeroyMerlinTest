package com.zoders.leroymerlintest.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zoders.leroymerlintest.data.ProductsPictures

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val productId: Int,
    val productName: String,
    val price: Int,
    //val drawableId: Int,
    val rating: Float,
    val reviews: Int,
    val bestPrice: Int,
    val onlineOnly: Int
)


/*@Entity(tableName = "Products")
data class ProductDB(
    @PrimaryKey(autoGenerate = true)
    val productId: Int,
    val productName: String,
    val price: Int,
    val rating: Float,
    val reviews: Int,
    val bestPrice: Int,
    val onlineOnly: Int
)*/