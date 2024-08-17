package com.cyryn.rebootapp.reboot.di

import android.content.Context
import com.cyryn.rebootapp.reboot.data.database.RebootDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataBaseModule {

    companion object {

        @Provides
        fun provideDataBase(context: Context): RebootDataBase {
            return RebootDataBase.getDataBase(context)
        }


    }
}