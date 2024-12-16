package com.example.finalpokus.storage

import android.content.Context

class TextStorage(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveText(text: String) {
        val editor = sharedPreferences.edit()
        editor.putString("savedText", text)
        editor.apply()
    }

    fun loadText(): String? {
        return sharedPreferences.getString("savedText", "")
    }
}
