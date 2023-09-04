package com.example.todolistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.todolistapp.databinding.ActivityAddTodoBinding
import com.example.todolistapp.databinding.ActivityHomeBinding

class AddTodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.btnCancel.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        val todoAdapter = TodoAdapter(sampleTodoList())

        setupButtonAdd(todoAdapter)


    }
    fun setupButtonAdd(todoAdapter: TodoAdapter) {
        binding.btnAdd.setOnClickListener {
            if (binding.etTodo.text.toString().isNotEmpty()) {
                todoAdapter.todoList.add(Todo(binding.etTodo.text.toString(), false))
                todoAdapter.notifyItemInserted(todoAdapter.todoList.size - 1)
                binding.etTodo.text?.clear()
            }
        }
    }
    private fun sampleTodoList(): MutableList<Todo> {
        return mutableListOf(

        )
    }
}
