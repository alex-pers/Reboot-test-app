package com.cyryn.rebootapp.reboot.data.dataStore

import com.cyryn.rebootapp.reboot.domain.model.RebootEvent

interface RebootEventsDataStore {
    suspend fun getRebootEvents(): List<RebootEvent>
    suspend fun addRebootEventHappened()
}