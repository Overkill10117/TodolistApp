package com.example.todolistapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.databinding.ActivityAddTodoBinding
import com.example.todolistapp.databinding.ActivityHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()


        binding.tocalendarbutton.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tologoutbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.toadd.setOnClickListener {
            val dialog = BottomSheetDialog(this)

            val view = layoutInflater.inflate(R.layout.activity_add_todo, null)


            val btnClose : Button = view.findViewById(R.id.btnCancel)


            btnClose.setOnClickListener {

                dialog.dismiss()
            }


            dialog.setContentView(view)


            dialog.show()
        }



    }
    private fun sampleTodoList(): MutableList<Todo> {
        return mutableListOf(

        )
    }

    private fun setupRecyclerView() {
        val todoAdapter = TodoAdapter(sampleTodoList())
        binding.todolist.apply {
            adapter = todoAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity)
            itemAnimator = null
        }
        AddTodoActivity().setupButtonAdd(todoAdapter)
        setupSwipeLeftToDelete(todoAdapter)
    }
    private fun setupSwipeLeftToDelete(todoAdapter: TodoAdapter) {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val removedItem = todoAdapter.todoList.removeAt(position)
                todoAdapter.notifyItemRemoved(position)

                Snackbar.make(
                    binding.root, "removed", Snackbar.LENGTH_LONG
                )
                    .setAction("undo") {
                        // Add the item back to the original data source
                        todoAdapter.todoList.add(position, removedItem)
                        todoAdapter.notifyItemInserted(position)
                    }
                    .show()
            }
        }).attachToRecyclerView(binding.todolist)
    }
}