package com.example.notificationproject

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

class NotificationApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val notificationChannel = NotificationChannel(
            "123",
            "notificaciones",
            NotificationManager.IMPORTANCE_HIGH
        )
        notificationChannel.description = "canal de notificaciones"
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
}