package com.vinodpatildev.twowaydemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private var userName = MutableLiveData<String>()
    val userNameData :LiveData<String>
    get()= userName

    init {
        userName.value = "Vinod Patil"
    }
}