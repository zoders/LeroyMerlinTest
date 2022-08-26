package com.zoders.leroymerlintest.data

import com.zoders.leroymerlintest.R

object ProductsPictures {
    private val pictures = mapOf(
        10002 to R.drawable.product1,
        10003 to R.drawable.product2,
        10004 to R.drawable.product3,
        10005 to R.drawable.product4,
        10006 to R.drawable.product5
    )

    fun getDrawableById(id: Int) = pictures[id]!!
}
