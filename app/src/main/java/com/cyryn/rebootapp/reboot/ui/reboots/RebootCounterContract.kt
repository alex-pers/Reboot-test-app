package com.cyryn.rebootapp.reboot.ui.reboots

data class RebootCounterUiState(
    val list: List<EventGroup> = emptyList()
)

data class EventGroup(
    val date: String,
    val count: Int,
)




