package com.example.act18_alejandro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarritoAdapter(private val carProducts: List<CarProducts>) :
    RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.productImage)
        val name: TextView = itemView.findViewById(R.id.productName)
        val price: TextView = itemView.findViewById(R.id.productPrice)
        val quantity: TextView = itemView.findViewById(R.id.tvQuantity)
        val subtotal: TextView = itemView.findViewById(R.id.tvSubtotal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_carrito, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = carProducts[position]
        val priceNum = item.product.price.replace(Regex("[^0-9.]"), "").toDoubleOrNull() ?: 0.0
        val sub = priceNum * item.quantity

        holder.image.setImageResource(item.product.imageResId)
        holder.name.text = item.product.name
        holder.price.text = item.product.price
        holder.quantity.text = "Quantitat: ${item.quantity}"
        holder.subtotal.text = "Subtotal: ${String.format("%.2f", sub)} €"
    }

    override fun getItemCount() = carProducts.size
}