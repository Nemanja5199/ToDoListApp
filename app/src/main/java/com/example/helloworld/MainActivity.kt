package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

private  lateinit var toDoAdapter: ToDoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toDoAdapter= ToDoAdapter(mutableListOf())

        rvToDoList.adapter=toDoAdapter
        rvToDoList.layoutManager= LinearLayoutManager(this)

       btnToDo.setOnClickListener {
           val todoTitle = etToDoTitle.text.toString()
           if(todoTitle.isNotEmpty()){
               val  todo = ToDo(todoTitle)
               toDoAdapter.addTodo(todo)
               etToDoTitle.text.clear()
           }
       }

        btnDeleteDoneToDoes.setOnClickListener {
            toDoAdapter.deleteDoneTodos()
        }



    }
}