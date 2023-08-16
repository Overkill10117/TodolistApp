package com.example.todolistapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog


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
            val dialog = BottomSheetDialog(this)

            // on below line we are inflating a layout file which we have created.
            val view = layoutInflater.inflate(R.layout.activity_add_todo, null)

            // on below line we are creating a variable for our button
            // which we are using to dismiss our dialog.
            val btnClose = view.findViewById<Button>(R.id.btnCancel)

            // on below line we are adding on click listener
            // for our dismissing the dialog button.
            btnClose.setOnClickListener {
                // on below line we are calling a dismiss
                // method to close our dialog.
                dialog.dismiss()
            }

            // on below line we are setting
            // content view to our view.
            dialog.setContentView(view)

            // on below line we are calling
            // a show method to display a dialog.
            dialog.show()
        }



    }
}