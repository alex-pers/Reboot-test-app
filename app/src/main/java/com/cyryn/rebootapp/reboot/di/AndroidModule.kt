package com.cyryn.rebootapp.reboot.di

import android.content.Context
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AndroidModule {

    companion object {
        @Provides
        fun provideContext(@ApplicationContext context: Context): Context = context

//        @Provides
//        fun provideSharedPrefs(@ApplicationContext context: Context): SharedPreferences {
//            return PreferenceManager.getDefaultSharedPreferences(context)
//        }

        @Provides
        fun provideWorkManager(@ApplicationContext context: Context): WorkManager {
            return WorkManager.getInstance(context)
        }
    }
}