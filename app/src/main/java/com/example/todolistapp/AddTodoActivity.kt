package com.example.todolistapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AddTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
    }
