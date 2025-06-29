package com.example.canteen.model

data class FoodItem(
    val id: String,
    val name: String,
    val price: Double,  // Changed from Int to Double
    val imageRes: Int
)
