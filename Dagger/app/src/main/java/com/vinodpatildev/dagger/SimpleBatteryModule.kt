package com.vinodpatildev.dagger

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SimpleBatteryModule {

    @Binds
    abstract fun providesSimpleBattery(simpleBattery: SimpleBattery): Battery
}