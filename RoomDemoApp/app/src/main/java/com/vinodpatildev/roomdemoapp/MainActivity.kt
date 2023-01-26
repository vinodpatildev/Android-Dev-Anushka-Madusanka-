package com.vinodpatildev.roomdemoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName
    private var noteViewModel: NoteViewModel? = null
    private var tv:TextView? = null
    private var addBtn:Button? = null
    private var showBtn:Button? = null
    private var deleteBtn:Button? = null



    private var getNoteResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            val resultTitle: String? = it.data?.getStringExtra("title")
            val resultNote: String? = it.data?.getStringExtra("note")
            tv?.setText(resultTitle)
            //Add to database

            val note = resultTitle?.let { title ->
                resultNote?.let{note->
                    Note(mTitle=title,mNote=note)
                }
            }
            GlobalScope.launch {
                if (note != null) {
                    noteViewModel?.addNote(note)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        addBtn = findViewById(R.id.btnAddNote)
        showBtn = findViewById(R.id.btnShowNote)
        deleteBtn = findViewById(R.id.btnDeleteNote)

        addBtn?.setOnClickListener({view->
            val intent = Intent(this@MainActivity,NewNoteActivity::class.java)
            getNoteResult.launch(intent)
        })
        showBtn?.setOnClickListener({view->
            val data = noteViewModel?.getAllNotes()
            data?.observe(this,Observer<List<Note>>{dataList->
                var output = ""
                for(item in dataList){
                    output += item.toString()
                }
                Toast.makeText(this,output,Toast.LENGTH_LONG).show()
            })

        })
        deleteBtn?.setOnClickListener({
            GlobalScope.launch {
                noteViewModel?.deleteAllNotes()
            }
        })

    }
}