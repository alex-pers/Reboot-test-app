package com.cyryn.rebootapp.reboot.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RebootsEventsDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(entity: RebootEventEntity)

    @Query(
        "SELECT * FROM reboot_events ORDER BY date"
    )
    suspend fun getAll(): List<RebootEventEntity>

}