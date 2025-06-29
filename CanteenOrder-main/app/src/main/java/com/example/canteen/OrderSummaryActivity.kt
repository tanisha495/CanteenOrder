package com.example.canteen

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderSummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_summary)

        val customerName = intent.getStringExtra("customer_name")
        val customerPhone = intent.getStringExtra("customer_phone")
        val customerAddress = intent.getStringExtra("customer_address")

        val tvDeliveryDetails = findViewById<TextView>(R.id.tvDeliveryDetails)
        tvDeliveryDetails.text = "Deliver to: $customerName\nPhone: $customerPhone\nAddress: $customerAddress"
    }
}
