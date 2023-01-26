package com.vinodpatildev.viewmodelapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityDataGenerator : ViewModel() {
    private var number = MutableLiveData<Int>()
    val numberData : LiveData<Int>
    get() = number

    init{
        generateNumber()
    }
    fun getNum(): MutableLiveData<Int> {
        return number
    }

    fun generateNumber(){
        number.value = Random.nextInt(Random.nextInt(0,49),Random.nextInt(50,100))
    }
}