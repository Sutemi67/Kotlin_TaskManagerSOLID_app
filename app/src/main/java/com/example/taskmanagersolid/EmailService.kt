package com.example.taskmanagersolid

class EmailService : NotificationService {

    override fun sendNotification(message: String) {
        println("Sending email with message: $message")
    }
}
