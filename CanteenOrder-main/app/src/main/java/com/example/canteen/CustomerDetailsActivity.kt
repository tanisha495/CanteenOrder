package com.example.canteen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.canteen.databinding.ActivityCustomerDetailsBinding

class CustomerDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString()
            val address = binding.etAddress.text.toString()

            if (name.isBlank() || phone.isBlank() || address.isBlank()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, OrderSummaryActivity::class.java)
                intent.putExtra("customer_name", name)
                intent.putExtra("customer_phone", phone)
                intent.putExtra("customer_address", address)
                startActivity(intent)
            }
        }
    }
}
