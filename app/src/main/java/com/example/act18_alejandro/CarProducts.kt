package com.example.act18_alejandro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CarProducts(
    val product: Product,
    val quantity: Int = 0
) :Parcelable