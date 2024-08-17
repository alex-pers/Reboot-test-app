package com.cyryn.rebootapp.reboot.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "reboot_events")
data class RebootEventEntity(
    @PrimaryKey
    val id: String,
    val date: Date,
)
