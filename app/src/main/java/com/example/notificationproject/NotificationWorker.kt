package com.example.notificationproject

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit
import kotlin.random.Random


class NotificationWorker(context: Context, params: WorkerParameters): Worker(context, params) {
    override fun doWork(): Result {
        showBasicNotification()
        return Result.success()
    }

    private fun showBasicNotification() {
        val notification = NotificationCompat.Builder(applicationContext, "123")
            .setContentTitle("Titulo")
            .setContentText("Lorem ipsum dolor sit amen")
            .setSmallIcon(R.drawable.notify)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }

    companion object {
        fun releaseNotification(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .setRequiresCharging(false)
                .setRequiresBatteryNotLow(false)
                .build()

            val notificationWork = OneTimeWorkRequest.Builder(NotificationWorker::class.java)
                .setConstraints(constraints)
                .setInitialDelay(7, TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance().enqueue(notificationWork)
        }
    }

}
