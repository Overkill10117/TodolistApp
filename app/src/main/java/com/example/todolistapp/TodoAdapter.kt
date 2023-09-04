package com.example.todolistapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.databinding.TodoitemBinding

class TodoAdapter(
    var todoList: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: TodoitemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TodoitemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoAdapter.ViewHolder, position: Int) {
        holder.binding.apply {
            title.text = todoList[position].title
            cbToDo.apply {
                isChecked = todoList[position].isChecked
                setOnClickListener {
                    todoList[position].isChecked = !todoList[position].isChecked
                }
            }
        }
    }

    override fun getItemCount(): Int {
       return todoList.size
    }

}