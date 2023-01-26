package com.vinodpatildev.lifecycleawaredemoapplication

import android.arch.lifecycle.LifecycleObserver
import android.util.Log

class MainActivityObserver : LifecycleObserver {

    fun onCreateEvent() {
        Log.i("Lifecycle","Observer:onCreateEvent()")
    }
}