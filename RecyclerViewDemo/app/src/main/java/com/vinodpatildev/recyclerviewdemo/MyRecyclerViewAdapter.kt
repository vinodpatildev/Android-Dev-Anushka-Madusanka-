package com.vinodpatildev.recyclerviewdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val items :List<Person>,
    private val clickListener:(Person)->Unit
    ): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setViewHolderData(items[position],clickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    fun setViewHolderData(
        person:Person,
        clickListener: (Person) -> Unit

    ){
        view.findViewById<TextView>(R.id.tvName).text = person.name
        view.findViewById<TextView>(R.id.tvSirname).text = person.sirname

        view.setOnClickListener({
            clickListener(person)
        })
    }
}