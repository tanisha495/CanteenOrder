package com.example.canteen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.canteen.R
import com.example.canteen.model.FoodItem

class FoodAdapter(
    private val itemList: List<FoodItem>,
    private val onClick: ((FoodItem) -> Unit)? = null,
    private val showAddButton: Boolean = true
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foodName: TextView = itemView.findViewById(R.id.tvFoodName)
        private val foodPrice: TextView = itemView.findViewById(R.id.tvFoodPrice)
        private val foodImage: ImageView = itemView.findViewById(R.id.ivFoodImage)
        private val addToCartButton: Button = itemView.findViewById(R.id.btnAddToCart)

        fun bind(item: FoodItem) {
            foodName.text = item.name
            foodPrice.text = "₹%.2f".format(item.price)
            foodImage.setImageResource(item.imageRes)

            // Show or hide button based on context (menu vs cart)
            if (showAddButton) {
                addToCartButton.visibility = View.VISIBLE
                addToCartButton.setOnClickListener {
                    onClick?.invoke(item)
                }
            } else {
                addToCartButton.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}
