package com.cyryn.rebootapp.reboot.data.repository

import com.cyryn.rebootapp.reboot.data.dataStore.RoomRebootEventsDataStore
import com.cyryn.rebootapp.reboot.domain.RebootEventsRepository
import com.cyryn.rebootapp.reboot.domain.model.RebootEvent
import javax.inject.Inject

class RebootEventsRepositoryImpl @Inject constructor(
    private val dataStore: RoomRebootEventsDataStore,
) : RebootEventsRepository {


    override suspend fun getRebootEvents(): List<RebootEvent> {

        return dataStore.getRebootEvents()
    }

    override suspend fun addRebootEventHappened() {
        dataStore.addRebootEventHappened()
    }
}