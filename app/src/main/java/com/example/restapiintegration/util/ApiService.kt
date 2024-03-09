package com.example.restapiintegration.util

import com.example.restapiintegration.User
import com.example.restapiintegration.UserX
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUserInfo() : Response<User>


}