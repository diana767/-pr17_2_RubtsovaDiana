package com.example.practika172

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity2 : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val keyName = "user_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val buttonSave: Button = findViewById(R.id.buttonSave)
        val textViewName: TextView = findViewById(R.id.textViewName)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // Проверка сохраненного имени
        val userName = sharedPreferences.getString(keyName, "")
        if (userName.isNullOrEmpty()) {
            textViewName.text = "Имя не введено"
        } else {
            textViewName.text = userName
        }
        // Сохранение имени при нажатии на кнопку
        buttonSave.setOnClickListener {
            val userName = editTextName.text.toString()
            sharedPreferences.edit().putString(keyName, userName).apply()
            if(userName!="") {
                textViewName.text = "Привет, $userName!"
            }else textViewName.text = "Имя не введено"
        }


    }
}