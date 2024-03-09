package com.example.restapiintegration.data

data class TheUser(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)