package com.vinodpatildev.viewmodelwithfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val initialValue:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(initialValue = initialValue) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}