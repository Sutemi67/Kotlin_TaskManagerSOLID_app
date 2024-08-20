package com.example.taskmanagersolid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val taskManager = TaskManager(EmailService())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        taskManager.addTask(Task(1, "Buy groceries", false))
        taskManager.addTask(Task(2, "Clean the house", false))

        taskManager.completeTask(1)
        taskManager.deleteTask(2)

        val tasks = taskManager.getTasks()
        tasks.forEach {
            println("Task: ${it.title}, Completed: ${it.isCompleted}")
        }
    }
}