package com.cyryn.rebootapp

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.cyryn.rebootapp.reboot.data.scheduler.RebootNotificationScheduler
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@HiltAndroidApp
class RebootApplication : Application(), Configuration.Provider {


    @Inject
    lateinit var scheduler: RebootNotificationScheduler


    override fun onCreate() {
        super.onCreate()
        scheduler.scheduleNotification()

    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder().setWorkerFactory(
            EntryPoints.get(this, HiltWorkerFactoryEntryPoint::class.java).workerFactory()
        ).build()


    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface HiltWorkerFactoryEntryPoint {
        fun workerFactory(): HiltWorkerFactory
    }
}