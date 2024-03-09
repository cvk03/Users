package com.example.restapiintegration

data class User(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<UserX>
)