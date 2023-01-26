package com.vinodpatildev.viewmodelwithfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.vinodpatildev.viewmodelwithfactory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory = MainViewModelFactory(100)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        binding.tvCount.text = viewModel.getCurCount().toString()
        binding.btnSubmit.setOnClickListener{
            binding.tvCount.text = viewModel.getIncCurCount().toString()
        }
    }
}