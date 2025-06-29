package com.example.canteen.ui.theme

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.CartActivity
import com.example.canteen.R
import com.example.canteen.model.FoodItem
import com.example.canteen.viewmodel.CartViewModel
import com.example.canteen.adapter.FoodAdapter
import com.example.canteen.MyApplication

class MenuActivity : AppCompatActivity() {

    private lateinit var cartViewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ✅ Shared ViewModel using Application's provider
        cartViewModel = (application as MyApplication)
            .viewModelProvider[CartViewModel::class.java]

        // ✅ Sample menu items
        val menuItems = listOf(
            FoodItem("1", "Maggie", 70.00, R.drawable.maggie),
            FoodItem("2", "Red Sauce Pasta", 80.00, R.drawable.pasta),
            FoodItem("3", "Steam Momos", 90.00, R.drawable.momos),
            FoodItem("4", "Fried Momos", 120.00, R.drawable.fried_momos),
            FoodItem("5", "Spring Roll", 60.00, R.drawable.spring_roll),
            FoodItem("6", "Sandwich", 40.00, R.drawable.sandwich),
            FoodItem("7", "Burger", 100.00, R.drawable.burger),
            FoodItem("8", "Pav Bhaji", 150.00, R.drawable.pav_bhaji),
            FoodItem("9", "Paneer Roll", 120.00, R.drawable.paneer_roll),
            FoodItem("10", "Pizza", 300.00, R.drawable.pizza),
            FoodItem("11", "Chilli Paneer", 150.00, R.drawable.chilli_paneer),
            FoodItem("12", "Chilli Potato", 120.00, R.drawable.chilli_potato),
            FoodItem("13", "Dosa", 150.00, R.drawable.dosa),
            FoodItem("14", "White Sauce Pasta", 80.00, R.drawable.wspasta),
            FoodItem("15", "Chole Bhature", 80.00, R.drawable.chola_bhatura),
            FoodItem("16", "Samosa", 15.00, R.drawable.samosa),
            FoodItem("17", "Water", 20.00, R.drawable.water),
            FoodItem("18", "Lassi", 80.00, R.drawable.lassi),
            FoodItem("19", "Sprite", 50.00, R.drawable.sprite),
            FoodItem("20", "CocaCola", 40.00, R.drawable.cocacola),
            FoodItem("21", "ThumbsUp", 50.00, R.drawable.thumbs_up),
            FoodItem("22", "Coffee", 20.00, R.drawable.coffee),
            FoodItem(id = "23", name = "Chai", price = 10.00, R.drawable.chai),
            FoodItem("24", "Soup", 20.00, R.drawable.soup),
            FoodItem("25", "Juice", 20.00, R.drawable.juice)
        )

        // ✅ Set up adapter and RecyclerView
        val adapter = FoodAdapter(menuItems, onClick = { item ->
            cartViewModel.addToCart(item)
            Toast.makeText(this, "${item.name} added to cart!", Toast.LENGTH_SHORT).show()
        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun openCart(view: View) {
        startActivity(Intent(this, CartActivity::class.java))
    }
}
