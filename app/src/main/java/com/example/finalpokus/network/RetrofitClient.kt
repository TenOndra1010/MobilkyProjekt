package com.example.finalpokus.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // Set the base URL
            .addConverterFactory(GsonConverterFactory.create())  // Add Gson converter for JSON parsing
            .build()
            .create(ApiService::class.java)  // Create the API service
    }
}
