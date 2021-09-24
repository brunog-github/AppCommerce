package com.example.appcommerce.model

import java.io.Serializable

data class User (
    val id: String,
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    val image: String,
    val addresses: List<UserAddress> = emptyList()
) : Serializable