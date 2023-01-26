package com.vinodpatildev.recyclerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    val listItems = listOf<Person>(
        Person("Vinod","Patil"),
        Person("Shubham","Patil"),
        Person("Yogesh","Kakade"),
        Person("Prathamesh","Chavan"),
        Person("Neeraj","Maurya"),
        Person("Vaishnavi","Salve"),
        Person("Prithvi","Aakare"),
        Person("Sudarshan","Khankhar"),
        Person("Aman","Shah"),
        Person("Pavan","Patel"),
        Person("Pavan","Sharma"),
        Person("Anup","Hijare")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MyRecyclerViewAdapter(listItems,{
            clickedItem:Person->viewClicked(clickedItem)
        })
    }
    private fun viewClicked(person:Person){
        Toast.makeText(
            this@MainActivity,
            "Name is ${person.name} and sirname is ${person.sirname}.",
            Toast.LENGTH_LONG
        ).show()
    }
}