package com.example.finalpokus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalpokus.model.User
import com.example.finalpokus.viewmodel.UserViewModel
import com.example.finalpokus.userinterface.UserAdapter
import com.example.finalpokus.storage.TextStorage

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var editText: EditText
    private lateinit var saveButton: Button
    private lateinit var textStorage: TextStorage
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        editText = findViewById(R.id.editText)
        saveButton = findViewById(R.id.saveButton)

        textStorage = TextStorage(this)

        userViewModel.users.observe(this) { users ->
            users?.let {
                val adapter = UserAdapter(it) { user ->
                    val intent = Intent(this, UserDetailsActivity::class.java)
                    intent.putExtra("USER_ID", user.id)
                    intent.putExtra("USER_NAME", user.name)
                    intent.putExtra("USER_EMAIL", user.email)
                    startActivity(intent)
                }
                recyclerView.adapter = adapter
            }
        }

        userViewModel.errorMessage.observe(this) { error ->
            error?.let {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
            }
        }

        userViewModel.fetchUsers()

        loadText()

        saveButton.setOnClickListener {
            val textToSave = editText.text.toString()
            if (textToSave.isNotEmpty()) {
                textStorage.saveText(textToSave)
                Toast.makeText(this, "Text saved!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadText() {
        val savedText = textStorage.loadText()
        editText.setText(savedText)
    }
}
