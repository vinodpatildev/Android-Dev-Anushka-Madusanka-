package com.vinodpatildev.roomdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vinodpatildev.roomdemo.databinding.ListItemBinding
import com.vinodpatildev.roomdemo.db.Subscriber

class SubscribersRecyclerViewAdapter(private val clickListener: (Subscriber) -> Unit): RecyclerView.Adapter<SubscriberViewHolder>() {
    val items = ArrayList<Subscriber>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return SubscriberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bind(items[position],clickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun setList(updatedItems:List<Subscriber>){
        items.clear()
        items.addAll(updatedItems)
    }
}

class SubscriberViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit){
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email

        binding.listItemLayout.setOnClickListener({
            clickListener(subscriber)
        })
    }
}