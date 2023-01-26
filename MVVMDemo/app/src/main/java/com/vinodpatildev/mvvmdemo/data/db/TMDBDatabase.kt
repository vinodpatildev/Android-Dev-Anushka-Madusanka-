package com.vinodpatildev.mvvmdemo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vinodpatildev.mvvmdemo.data.model.artist.Artist
import com.vinodpatildev.mvvmdemo.data.model.movie.Movie
import com.vinodpatildev.mvvmdemo.data.model.tvshow.TvShow

@Database(entities = [Artist::class, Movie::class, TvShow::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun artistDao(): ArtistDao
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
}