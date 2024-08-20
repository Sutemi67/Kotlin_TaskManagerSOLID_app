package com.example.taskmanagersolid

class TaskManager(private val notificationService: NotificationService) {
    private val tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun completeTask(taskId: Int) {
        val task = tasks.find { it.id == taskId }
        task?.let {
            it.isCompleted = true
            notificationService.sendNotification("Task '${it.title}' is completed.")
        }
    }

    fun deleteTask(taskId: Int) {
        tasks.removeAll { it.id == taskId }
    }

    fun getTasks(): List<Task> {
        return tasks
    }
}