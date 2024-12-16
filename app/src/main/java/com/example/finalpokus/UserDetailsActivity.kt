package com.example.finalpokus

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var textViewEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        textViewName = findViewById(R.id.textViewName)
        textViewEmail = findViewById(R.id.textViewEmail)

        val userName = intent.getStringExtra("USER_NAME")
        val userEmail = intent.getStringExtra("USER_EMAIL")

        textViewName.text = "Name: $userName"
        textViewEmail.text = "Email: $userEmail"
    }
}
