package com.cyryn.rebootapp.reboot.data.database

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun timestampToDate(from: Long?): Date? {
        return Date(from ?: 0)
    }

    @TypeConverter
    fun dateToTimestamp(from: Date?): Long? {
        return from?.time
    }
}