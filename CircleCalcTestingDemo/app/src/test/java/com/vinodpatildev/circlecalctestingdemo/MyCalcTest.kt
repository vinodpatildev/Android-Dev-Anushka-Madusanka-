package com.vinodpatildev.circlecalctestingdemo

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class MyCalcTest {
    private lateinit var myCalc: MyCalc
    @Before
    fun setUp(){
        myCalc = MyCalc()
    }

    @Test
    fun calculateCircumference_giverRadius_returnsCorrectResult() {
        assertThat(myCalc.calculateCircumference(2.1)).isEqualTo(13.188)
    }

    @Test
    fun calculateArea_givenRadius_returnsCorrectResult() {
        assertThat(myCalc.calculateArea(2.1)).isEqualTo(13.8474)
    }
}