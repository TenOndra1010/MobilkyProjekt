package com.example.finalpokus.network

import retrofit2.Call
import retrofit2.http.GET
import com.example.finalpokus.model.User

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}

