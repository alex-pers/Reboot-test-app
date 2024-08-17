package com.cyryn.rebootapp.reboot.domain.usecase

import com.cyryn.rebootapp.reboot.domain.RebootEventsRepository
import com.cyryn.rebootapp.reboot.domain.model.RebootEvent
import javax.inject.Inject

class GetRebootEventsUseCase @Inject constructor(
    private val repository: RebootEventsRepository
) {

    suspend operator fun invoke(): List<RebootEvent> {
        return repository.getRebootEvents()
    }
}