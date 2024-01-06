package com.example.quickmart.model

import java.io.Serializable

data class CartItem(
    val productName: String,
    val productImage: String,
    var quantity: Double,
    val price:Double
) : Serializable {
    fun calculateTotalPrice(): Double {
        return quantity * price
    }
}
