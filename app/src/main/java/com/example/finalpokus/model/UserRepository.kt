package com.example.finalpokus.model

import com.example.finalpokus.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun getUsers(callback: (List<User>?, String?) -> Unit) {
        RetrofitClient.apiService.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    callback(response.body(), null)
                } else {
                    callback(null, "Failed to fetch data")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                callback(null, "Error: ${t.message}")
            }
        })
    }
}
