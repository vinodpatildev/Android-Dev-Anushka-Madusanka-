package com.vinodpatildev.stopwatchservicedemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vinodpatildev.stopwatchservicedemo.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var isStarted = false
    private lateinit var serviceIntent: Intent
    private var time = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartStop.setOnClickListener{
            startOrStop()
        }

        binding.btnReset.setOnClickListener{
            reset()
        }
        serviceIntent = Intent(applicationContext, StopWatchService::class.java)
        registerReceiver(updateTime, IntentFilter(StopWatchService.UPDATED_TIME) )
    }
    fun startOrStop(){
        if(isStarted){
            stop()
        }else{
            start()
        }
    }
    fun start(){
        serviceIntent.putExtra(StopWatchService.CURRENT_TIME,time)
        startService(serviceIntent)
        isStarted = true
        binding.btnStartStop.text = "stop"
    }
    fun stop(){
        stopService(serviceIntent)
        isStarted = false
        binding.btnStartStop.text = "start"
    }
    fun reset(){
        stop()
        time = 0.0
        binding.tvTimer.text = getFormatedTime(time)
    }
    private val updateTime : BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                time = intent.getDoubleExtra(StopWatchService.CURRENT_TIME, 0.0)
            }
            binding.tvTimer.text = getFormatedTime(time)
        }

    }
    private fun getFormatedTime(time:Double):String{
        val timeInt = time.roundToInt()
        val hours = timeInt % 86400 / 3600
        val minutes = timeInt % 86400 % 3600 / 60
        val seconds = timeInt % 86400 % 3600 % 60

        return String.format("%02d:%02d:%02d",hours,minutes,seconds)
    }
}