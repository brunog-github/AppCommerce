package com.example.appcommerce.model

import java.io.Serializable

data class ProductCategory (
    val id: String,
    val title: String,
    val product: List<Product> = emptyList()
    ) : Serializable