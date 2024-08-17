package com.cyryn.rebootapp.reboot.data.scheduler

import android.app.Notification
import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.cyryn.rebootapp.NotificationHelper
import com.cyryn.rebootapp.R
import com.cyryn.rebootapp.reboot.data.database.RebootDataBase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RebootNotificationScheduler @Inject constructor(
    private val workManager: WorkManager,
    private val dataBase: RebootDataBase,
) {

    fun scheduleNotification() {
        val request = PeriodicWorkRequest.Builder(
            NotificationSchedulerWorker::class.java,
            15,
            TimeUnit.MINUTES
        ).build()

        workManager.enqueueUniquePeriodicWork("lol", ExistingPeriodicWorkPolicy.UPDATE, request)
    }

    @HiltWorker
    class NotificationSchedulerWorker @AssistedInject constructor(
        @Assisted context: Context,
        @Assisted workerParameters: WorkerParameters,
        private val notificationHelper: NotificationHelper
    ) : Worker(context, workerParameters) {
        override fun doWork(): Result {

            notificationHelper.showNotification(R.id.notification_id, createNotification())
            return Result.success()

        }

        private fun createNotification(): Notification {
            //todo get date from DB and format title and content
            return notificationHelper.createNotification("title", "content")
        }

    }

}