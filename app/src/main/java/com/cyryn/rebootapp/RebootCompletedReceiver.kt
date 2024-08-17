package com.cyryn.rebootapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.cyryn.rebootapp.reboot.domain.usecase.SaveRebootEventUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RebootCompletedReceiver : BroadcastReceiver() {
    @Inject
    lateinit var useCase: SaveRebootEventUseCase

    override fun onReceive(context: Context?, intent: Intent?) {
        GlobalScope.launch {
            runCatching {
                useCase()
            }.onFailure { // todo add log

            }

        }
    }
}