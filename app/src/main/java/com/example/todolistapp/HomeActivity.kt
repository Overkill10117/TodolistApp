package com.example.todolistapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val calendar : Button = findViewById(R.id.tocalendarbutton)
        val logout : Button = findViewById(R.id.tologoutbutton)
        val add : Button = findViewById(R.id.toadd)


        calendar.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
            finish()
        }
        logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        add.setOnClickListener {
            val intent = Intent(this, AddTodoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}