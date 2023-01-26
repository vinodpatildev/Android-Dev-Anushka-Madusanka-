package com.vinodpatildev.mvvmdemo.domain.repository

import com.vinodpatildev.mvvmdemo.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}