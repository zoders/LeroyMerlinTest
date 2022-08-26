package com.zoders.leroymerlintest.data

import com.zoders.leroymerlintest.R

enum class Category(var drawableId: Int, var title: String) {
    CATEGORY1(R.drawable.category1, "Шпаклевки базовые"),
    CATEGORY2(R.drawable.category2, "Шпаклевки финишные"),
    CATEGORY3(R.drawable.category3, "Шпаклевки суперфинишные")
}

fun getCategoriesList() = listOf(Category.CATEGORY1, Category.CATEGORY2, Category.CATEGORY3)
