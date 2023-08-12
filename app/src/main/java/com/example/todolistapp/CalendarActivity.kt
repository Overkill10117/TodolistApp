package com.example.todolistapp

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        val actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}