package com.example.restapiintegration.util

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper{

    private val base_url = "https://dummyjson.com/"

  fun get_instance(): Retrofit{

      var gson  = GsonBuilder()
          .create()

      val retrofit : Retrofit = Retrofit.Builder()
          .baseUrl(base_url)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build()

      return retrofit
  }
}