package com.cyryn.rebootapp.reboot.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [RebootEventEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class RebootDataBase : RoomDatabase() {

    abstract fun getRebootEventsDao(): RebootsEventsDao

    companion object {
        @Volatile
        private var INSTANCE: RebootDataBase? = null

        fun getDataBase(context: Context): RebootDataBase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    RebootDataBase::class.java,
                    "reboot_data_base"
                ).fallbackToDestructiveMigration().build().also {
                    INSTANCE = it
                }
            }
        }

    }
}