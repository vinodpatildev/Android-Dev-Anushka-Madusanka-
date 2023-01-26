package com.vinodpatildev.roomdemoapp

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao:NoteDao) {
    suspend fun insertNotes(note:Note) = noteDao.insert(note)

    suspend fun updateNotes(note:Note) = noteDao.update(note)

    suspend fun deleteNotes(note:Note) = noteDao.delete(note)

    fun getAllNotes(): LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun deleteAllNotes() = noteDao.deleteAllNotes()
}