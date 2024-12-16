package com.example.finalpokus.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalpokus.model.User
import com.example.finalpokus.model.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository = UserRepository()
    val users = MutableLiveData<List<User>>()
    val errorMessage = MutableLiveData<String>()

    fun fetchUsers() {
        userRepository.getUsers { userList, error ->
            if (userList != null) {
                users.value = userList
            } else {
                errorMessage.value = error
            }
        }
    }
}
