package com.vinodpatildev.dagger

import javax.inject.Inject

class SimpleBattery @Inject constructor(): Battery {
    override fun getPower() {
        print("getting power....")
    }
}