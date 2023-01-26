package com.vinodpatildev.kotlincoroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    launch(Dispatchers.Default) {
        fun fun1(){
            println("inner function of launch.");
        }
        println("coroutine :${this.toString()}")
        launch(Dispatchers.Default) {
            fun fun1(){
                println("inner function of child of launch.");
            }
            println("coroutine :${this.toString()}")

        }
    }
    async {
        fun fun1(){
            println("inner function of async.");
        }
        println("coroutine :${this.toString()}")
    }
    runBlocking {
        fun fun1(){
            println("inner function of runBlocking.");
        }
        println("coroutine :${this.toString()}")
    }
}
