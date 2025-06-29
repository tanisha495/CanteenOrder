// CartViewModel.kt
package com.example.canteen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.canteen.model.FoodItem

class CartViewModel : ViewModel() {
    private val cartItems = mutableListOf<FoodItem>()

    fun addToCart(item: FoodItem) {
        cartItems.add(item)
    }

    fun getCartItems(): List<FoodItem> = cartItems

    fun clearCart() {
        cartItems.clear()
    }
}
