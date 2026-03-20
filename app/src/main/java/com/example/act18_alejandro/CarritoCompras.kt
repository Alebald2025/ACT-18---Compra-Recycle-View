package com.example.act18_alejandro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarritoCompras : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito_compras)

        val recyclerSummary: RecyclerView = findViewById(R.id.recyclerSummary)
        val btnBack: Button = findViewById(R.id.btnBack)
        val btnConfirm: Button = findViewById(R.id.btnConfirm)

        val cartList: ArrayList<CarProducts>? = intent.getParcelableArrayListExtra("cart_list")

        val items = cartList ?: arrayListOf()

        recyclerSummary.layoutManager = LinearLayoutManager(this)
        recyclerSummary.adapter = CarritoAdapter(items)

        btnBack.setOnClickListener { finish() }

        btnConfirm.setOnClickListener {
            if (items.isEmpty()) {
                Toast.makeText(this, "El carrito está vacio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.d("COMPRA", "=== COMPRA CONFIRMADA ===")
            items.forEach { item ->
                val priceNum = item.product.price.replace(Regex("[^0-9.]"), "").toDoubleOrNull() ?: 0.0
                val subtotal = priceNum * item.quantity
                Log.d("COMPRA", "${item.quantity} × ${item.product.name} (${item.product.price}) → ${String.format("%.2f", subtotal)} €")
            }
            val total = items.sumOf { item ->
                val p = item.product.price.replace(Regex("[^0-9.]"), "").toDoubleOrNull() ?: 0.0
                p * item.quantity
            }
            Log.d("COMPRA", "TOTAL: ${String.format("%.2f", total)} €")
            Log.d("COMPRA", "Gracias por la compra!")

            Toast.makeText(this, "Compra confirmada!", Toast.LENGTH_LONG).show()
        }
    }
}