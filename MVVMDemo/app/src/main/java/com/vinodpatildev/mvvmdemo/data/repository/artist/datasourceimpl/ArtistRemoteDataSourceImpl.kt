package com.vinodpatildev.mvvmdemo.data.repository.artist.datasourceimpl

import com.vinodpatildev.mvvmdemo.data.api.TMDBService
import com.vinodpatildev.mvvmdemo.data.model.artist.Artist
import com.vinodpatildev.mvvmdemo.data.model.artist.ArtistList
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }

}