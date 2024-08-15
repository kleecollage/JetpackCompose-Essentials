package com.example.notificationproject

import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import kotlin.random.Random

class NotificationService(private val context: Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun showBasicNotification() {
        val notification = NotificationCompat.Builder(context, "123")
            .setContentTitle("Titulo")
            .setContentText("Lorem ipsum dolor sit amen")
            .setSmallIcon(R.drawable.notify)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()
        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun showLargeNotification() {
        val notification = NotificationCompat.Builder(context, "123")
            .setContentTitle("Titulo")
            .setContentText("Lorem ipsum dolor sit amen")
            .setSmallIcon(R.drawable.notify)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setStyle(
                NotificationCompat
                    .BigTextStyle()
                    .bigText("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet… Este fragmento proviene de las secciones 1.10.32 y 1.10.33 de “De finibus bonorum et malorum” (Los extremos del bien y el mal), escrito por Cicerón en el año 45 a.C.")
            )
            .setAutoCancel(true)
            .build()
        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun showInboxNotification() {
        val notification = NotificationCompat.Builder(context, "123")
            .setContentTitle("Titulo")
            .setContentText("Lorem ipsum dolor sit amen")
            .setSmallIcon(R.drawable.notify)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setStyle(
                NotificationCompat
                    .InboxStyle()
                    .addLine("Linea 1")
                    .addLine("Linea 2")
                    .addLine("Linea 3")
                    .addLine("Linea 4")
                    .addLine("Linea 5")
            )
            .setAutoCancel(true)
            .build()
        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    fun showImageNotification() {
        val image = context.bitmapFromResource(R.drawable.ic_notify)
        val notification = NotificationCompat.Builder(context, "123")
            .setContentTitle("Titulo")
            .setContentText("Lorem ipsum dolor sit amen")
            .setSmallIcon(R.drawable.ic_notify)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setLargeIcon(image)
            .setStyle(
                NotificationCompat
                    .BigPictureStyle()
                    .bigPicture(image)
                    .bigLargeIcon(null as Bitmap?)
            )
            .setAutoCancel(true)
            .build()
        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    private fun Context.bitmapFromResource(
        @DrawableRes resId: Int
    ) = BitmapFactory.decodeResource(
        resources,
        resId
    )








}