package com.vinodpatildev.mvvmdemo.data.repository.artist.datasource

import com.vinodpatildev.mvvmdemo.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists():Response<ArtistList>
}