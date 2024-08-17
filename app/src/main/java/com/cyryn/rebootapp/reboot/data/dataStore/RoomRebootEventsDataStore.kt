package com.cyryn.rebootapp.reboot.data.dataStore

import com.cyryn.rebootapp.reboot.data.database.RebootDataBase
import com.cyryn.rebootapp.reboot.data.database.RebootEventEntity
import com.cyryn.rebootapp.reboot.domain.model.RebootEvent
import java.util.Date
import java.util.UUID
import javax.inject.Inject

class RoomRebootEventsDataStore @Inject constructor(
    private val dataBase: RebootDataBase
) : RebootEventsDataStore {
    override suspend fun getRebootEvents(): List<RebootEvent> {
        return dataBase.getRebootEventsDao().getAll().map {
            RebootEvent(it.date)
        }
    }

    override suspend fun addRebootEventHappened() {
        dataBase.getRebootEventsDao()
            .insert(RebootEventEntity(UUID.randomUUID().toString(), Date()))
    }
}