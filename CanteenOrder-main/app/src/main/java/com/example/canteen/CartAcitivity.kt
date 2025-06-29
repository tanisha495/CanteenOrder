package com.example.canteen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.adapter.FoodAdapter
import com.example.canteen.viewmodel.CartViewModel
import android.widget.Toast

class CartActivity : AppCompatActivity() {

    private lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // ✅ ViewModel from Application
        cartViewModel = (application as MyApplication)
            .viewModelProvider[CartViewModel::class.java]

        val cartItems = cartViewModel.getCartItems()

        val totalPrice = cartItems.sumOf { it.price }
        findViewById<TextView>(R.id.tvTotalPrice).text = "Total: ₹%.2f".format(totalPrice)

        val adapter = FoodAdapter(cartItems, showAddButton = false)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCart)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // ✅ Navigate to CustomerDetailsActivity instead of placing the order directly
        findViewById<Button>(R.id.btnCheckout).setOnClickListener {
            if (cartItems.isEmpty()) {
                Toast.makeText(this, "Your cart is empty!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, CustomerDetailsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
