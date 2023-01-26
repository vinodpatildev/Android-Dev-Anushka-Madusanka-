package com.vinodpatildev.circlecalctestingdemo

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito

class CalcViewModelTest {
    private lateinit var calcViewModel: CalcViewModel
    private lateinit var calcuations : Calculations

    @Before
    fun setUp(){
        calcuations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calcuations.calculateArea(2.1)).thenReturn(13.8474)
        calcViewModel = CalcViewModel(calcuations)
    }

    @Test
    fun calculate() {
    }

    @Test
    fun calculateArea() {
    }

    @Test
    fun calculateCircumference() {
    }
}