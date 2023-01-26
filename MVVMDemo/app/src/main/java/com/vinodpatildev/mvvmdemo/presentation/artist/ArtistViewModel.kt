package com.vinodpatildev.mvvmdemo.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vinodpatildev.mvvmdemo.domain.usecases.GetArtistUseCase
import com.vinodpatildev.mvvmdemo.domain.usecases.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
):ViewModel() {
    fun getArtist() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }
    fun updateArtist() = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}