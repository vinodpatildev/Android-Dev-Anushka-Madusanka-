package com.vinodpatildev.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class, SimpleBatteryModule::class])
interface SmartPhoneComponent {
    fun inject(mainActivity: MainActivity)
}