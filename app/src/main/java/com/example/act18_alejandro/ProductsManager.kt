package com.example.act18_alejandro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsManager : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_manager)

        val productList = listOf(
            Product("Laptop", "$1200", R.drawable.ic_launcher_background),
            Product("Smartphone", "$800", R.drawable.ic_launcher_background),
            Product("Headphones", "$100", R.drawable.ic_launcher_background),
            Product("Mouse", "$60", R.drawable.ic_launcher_background),
            Product("Keyboard", "$80", R.drawable.ic_launcher_background),
            Product("Microphone", "$150", R.drawable.ic_launcher_background),
            Product("Sound System", "$220", R.drawable.ic_launcher_background)
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(productList)
    }
}
