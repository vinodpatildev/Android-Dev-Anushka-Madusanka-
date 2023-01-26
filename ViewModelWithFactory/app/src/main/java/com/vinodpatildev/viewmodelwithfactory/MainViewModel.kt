package com.vinodpatildev.viewmodelwithfactory

import androidx.lifecycle.ViewModel

class MainViewModel(initialValue:Int):ViewModel() {
    private var count = 0;
    init {
        count = initialValue
    }
    fun getCurCount():Int{
        return count;
    }
    fun getIncCurCount():Int{
        return ++count;
    }
}