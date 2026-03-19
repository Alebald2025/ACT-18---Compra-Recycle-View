package com.example.act18_alejandro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuShop = findViewById<Button>(R.id.buttonShop)
        menuShop.setOnClickListener{
            val intent = Intent(this, ProductsManager::class.java)
            startActivity(intent)
        }


    }
}