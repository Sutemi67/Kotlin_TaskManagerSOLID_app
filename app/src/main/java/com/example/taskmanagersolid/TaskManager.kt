package com.example.taskmanagersolid

class TaskManager {
    private val tasks = mutableListOf<Task>()
    private val emailService = EmailService()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun completeTask(taskId: Int) {
        val task = tasks.find { it.id == taskId }
        task?.let {
            it.isCompleted = true
            emailService.sendEmail("Task '${it.title}' is completed.")
        }
    }

    fun deleteTask(taskId: Int) {
        tasks.removeAll { it.id == taskId }
    }

    fun getTasks(): List<Task> {
        return tasks
    }
}