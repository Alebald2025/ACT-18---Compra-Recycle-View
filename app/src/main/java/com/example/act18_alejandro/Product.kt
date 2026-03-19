package com.example.act18_alejandro

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String,
    val price: String,
    val imageResId: Int
) :Parcelable