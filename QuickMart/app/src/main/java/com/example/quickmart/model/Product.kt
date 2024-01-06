package com.example.quickmart.model
import java.io.Serializable

data class Product(
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val range: Int,
    val imageName: String
) : Serializable

