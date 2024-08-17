package com.cyryn.rebootapp.reboot.ui.reboots

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyryn.rebootapp.reboot.domain.usecase.GetRebootEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class RebootsFragmentViewModel @Inject constructor(
    private val getRebootEventsUseCase: GetRebootEventsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(RebootCounterUiState())
    val uiState: StateFlow<RebootCounterUiState>
        get() = _uiState

    init {
        viewModelScope.launch {
            runCatching {
                val result = getRebootEventsUseCase()

                val events = result.groupBy {
                    SimpleDateFormat("dd/MM/yyyy").format(it.date)
                }.mapValues { (_, events) -> events.size }.entries.map {
                    EventGroup(
                        it.key,
                        it.value
                    )
                }

                _uiState.value = RebootCounterUiState(events)

            }
        }
    }


}