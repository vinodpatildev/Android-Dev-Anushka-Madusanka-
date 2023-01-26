package com.vinodpatildev.mvvmdemo.domain.usecases

import com.vinodpatildev.mvvmdemo.data.model.artist.Artist
import com.vinodpatildev.mvvmdemo.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtist()
}