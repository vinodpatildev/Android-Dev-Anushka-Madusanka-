package com.vinodpatildev.mvvmdemo.data.repository.artist.datasource

import com.vinodpatildev.mvvmdemo.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}