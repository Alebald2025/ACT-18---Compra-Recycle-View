package com.example.act18_alejandro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsManager : AppCompatActivity() {

    private val products = listOf(
        Product("Laptop", "1200.00 €", R.drawable.laptop),
        Product("Smartphone", "800.00 €", R.drawable.smarthpone),
        Product("Headphones", "100.00 €", R.drawable.headphones),
        Product("Mouse", "60.00 €", R.drawable.mouse),
        Product("Keyboard", "80.00 €", R.drawable.keyboard)
    )

    private val cart = mutableMapOf<Product, Int>()

    private lateinit var tvTotal: TextView
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_manager)

        tvTotal = findViewById(R.id.tvTotal)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val btnSummary: Button = findViewById(R.id.btnGoToSummary)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ProductAdapter(products, cart) { updateTotal() }
        recyclerView.adapter = adapter

        btnSummary.setOnClickListener {
            val cartList = cart.map { (product, qty) ->
                CarProducts(product, qty)
            }.filter { it.quantity > 0 }

            val intent = Intent(this, CarritoCompras::class.java)
            intent.putParcelableArrayListExtra("cart_list", ArrayList(cartList))
            startActivity(intent)
        }

        updateTotal()
    }

    private fun updateTotal() {
        var total = 0.0
        cart.forEach { (product, qty) ->
            val priceNum = product.price.replace(Regex("[^0-9.]"), "").toDoubleOrNull() ?: 0.0
            total += priceNum * qty
        }
        tvTotal.text = "Total: ${String.format("%.2f", total)} €"
    }
}
