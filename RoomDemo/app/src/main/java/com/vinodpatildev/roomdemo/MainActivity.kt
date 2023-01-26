package com.vinodpatildev.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.vinodpatildev.roomdemo.databinding.ActivityMainBinding
import com.vinodpatildev.roomdemo.db.Subscriber
import com.vinodpatildev.roomdemo.db.SubscriberDatabase
import com.vinodpatildev.roomdemo.db.SubscriberRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel:SubscriberViewModel
    private lateinit var adapter: SubscribersRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this

        val dao = SubscriberDatabase.getInstance(this.applicationContext).subscriberDAO
        val repository = SubscriberRepository(dao)
        val subscriberViewModelFactory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this,subscriberViewModelFactory).get(SubscriberViewModel::class.java)
        binding.subscriberViewModel = subscriberViewModel
        initRecyclerView()
        subscriberViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let{
                Snackbar.make(binding.root,it ,Snackbar.LENGTH_LONG).show()
            }
        })
    }
    private fun initRecyclerView(){
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SubscribersRecyclerViewAdapter() { subscriber: Subscriber ->
            listItemClicked(
                subscriber
            )
        }
        binding.subscriberRecyclerView.adapter = adapter
        displaySubscribersList()
    }
    private fun displaySubscribersList(){
        subscriberViewModel.subscribers.observe(this, Observer {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }
    private fun listItemClicked(subscriber:Subscriber){
        subscriberViewModel.initUpdateAndDelete(subscriber)
    }
}