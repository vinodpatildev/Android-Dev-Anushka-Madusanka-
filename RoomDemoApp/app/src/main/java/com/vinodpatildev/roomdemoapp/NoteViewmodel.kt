package com.vinodpatildev.roomdemoapp

import android.app.Activity
import android.app.Application
import androidx.lifecycle.*
import androidx.room.RoomDatabase
import com.vinodpatildev.roomdemoapp.NoteRoomDatabase.Companion.getDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private var noteDao:NoteDao? = null
    private val repository: NoteRepository
    private var readAll : LiveData<List<Note>>

    init{
        noteDao = NoteRoomDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao as NoteDao)
        readAll = repository.getAllNotes()
    }

    fun addNote(note : Note){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertNotes(note)
        }
    }
    fun getAllNotes():LiveData<List<Note>>{
        return readAll
    }
    fun deleteAllNotes(){
        viewModelScope.launch(Dispatchers.IO){
            noteDao?.deleteAllNotes()
        }

    }
}

