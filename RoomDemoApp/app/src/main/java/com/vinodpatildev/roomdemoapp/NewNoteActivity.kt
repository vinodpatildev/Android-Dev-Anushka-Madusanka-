package com.vinodpatildev.roomdemoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class NewNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etNote = findViewById<EditText>(R.id.etNote)
        val addBtn = findViewById<Button>(R.id.btnAdd)

        addBtn.setOnClickListener({ view->
            if(etTitle.text.isEmpty() or etNote.text.isEmpty()){
                Snackbar.make(view,"Please write your notes",Snackbar.LENGTH_LONG).show()
            }else{
                val resultIntent = Intent()
                resultIntent.putExtra("title",etTitle.text.toString())
                resultIntent.putExtra("note",etNote.text.toString())
                setResult(Activity.RESULT_OK,resultIntent)
                finish()
            }
        })
    }
}