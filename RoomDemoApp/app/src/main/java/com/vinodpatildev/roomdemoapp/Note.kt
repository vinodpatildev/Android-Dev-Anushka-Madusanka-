package com.vinodpatildev.roomdemoapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    @ColumnInfo(name="title") val mTitle:String="",
    @ColumnInfo(name="note") val mNote:String="",
)