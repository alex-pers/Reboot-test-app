package com.cyryn.rebootapp.reboot.domain

import com.cyryn.rebootapp.reboot.domain.model.RebootEvent

interface RebootEventsRepository {

    suspend fun getRebootEvents(): List<RebootEvent>
    suspend fun addRebootEventHappened()
}