package com.cyryn.rebootapp.reboot.domain.usecase

import com.cyryn.rebootapp.reboot.domain.RebootEventsRepository
import javax.inject.Inject

class SaveRebootEventUseCase @Inject constructor(
    private val repository: RebootEventsRepository
) {
    suspend operator fun invoke() {
        repository.addRebootEventHappened()
    }
}