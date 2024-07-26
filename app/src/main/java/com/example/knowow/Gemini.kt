package com.example.knowow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Gemini : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gemini)

//        val prompt = findViewById<EditText>(R.id.prompt)
        val btn = findViewById<Button>(R.id.submit)
        val result = findViewById<TextView>(R.id.result)

        btn.setOnClickListener{
            val generativeModel = GenerativeModel(
                modelName = "gemini-pro",
//                apiKey = resources.getString(R.string.api_key)
                apiKey = "apikey"
            )


            val prompt = "Write a story about a magic backpack."
            MainScope().launch {
                val response = generativeModel.generateContent(prompt)
                result.text = response.toString()
                Log.d("Gemini", response.toString())
            }
        }

    }
}
