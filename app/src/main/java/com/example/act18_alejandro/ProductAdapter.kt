package com.example.act18_alejandro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val products: List<Product>,
    private val cart: MutableMap<Product, Int>,  // <Product, quantitat>
    private val onCartChanged: () -> Unit
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.productImage)
        val name: TextView = itemView.findViewById(R.id.productName)
        val price: TextView = itemView.findViewById(R.id.productPrice)
        val quantity: TextView = itemView.findViewById(R.id.tvQuantity)
        val btnPlus: Button = itemView.findViewById(R.id.btnPlus)
        val btnMinus: Button = itemView.findViewById(R.id.btnMinus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        val qty = cart.getOrDefault(product, 0)

        holder.image.setImageResource(product.imageResId)
        holder.name.text = product.name
        holder.price.text = product.price
        holder.quantity.text = qty.toString()

        holder.btnPlus.setOnClickListener {
            cart[product] = qty + 1
            notifyItemChanged(position)
            onCartChanged()
        }

        holder.btnMinus.setOnClickListener {
            if (qty > 0) {
                cart[product] = qty - 1
                notifyItemChanged(position)
                onCartChanged()
            }
        }
    }

    override fun getItemCount() = products.size
}
