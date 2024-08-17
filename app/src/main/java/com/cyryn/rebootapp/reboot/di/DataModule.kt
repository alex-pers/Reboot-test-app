package com.cyryn.rebootapp.reboot.di

import com.cyryn.rebootapp.reboot.data.dataStore.RebootEventsDataStore
import com.cyryn.rebootapp.reboot.data.dataStore.RoomRebootEventsDataStore
import com.cyryn.rebootapp.reboot.data.repository.RebootEventsRepositoryImpl
import com.cyryn.rebootapp.reboot.domain.RebootEventsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindDataStore(impl: RoomRebootEventsDataStore): RebootEventsDataStore

    @Binds
    fun bindRepository(impl: RebootEventsRepositoryImpl): RebootEventsRepository
}