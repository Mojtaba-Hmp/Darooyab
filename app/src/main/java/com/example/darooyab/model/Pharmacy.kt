package com.example.darooyab.model

data class Pharmacy(
    val id: Int,
    val name: String,
    val address: String,
    val phone: String,
    val drugsList: MutableList<Int>
)
