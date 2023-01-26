package com.vinodpatildev.mvvmdemo.data.repository.artist

import android.util.Log
import com.vinodpatildev.mvvmdemo.data.model.artist.Artist
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistCacheDataSource
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistLocalDataSource
import com.vinodpatildev.mvvmdemo.data.repository.artist.datasource.ArtistRemoteDataSource
import com.vinodpatildev.mvvmdemo.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
):ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        var newArtistList = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newArtistList)
        artistCacheDataSource.saveArtistsToCache(newArtistList)
        return newArtistList
    }
    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            var response = artistRemoteDataSource.getArtists()
            var body = response.body()
            if(body != null){
                artistList = body.artists
            }
        } catch (exception :Exception){
            Log.i("mylog",exception.message.toString())
        }
        return artistList
    }
    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception :Exception){
            Log.i("mylog",exception.message.toString())
        }
        if(artistList.size<=0){
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }
    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception :Exception){
            Log.i("mylog",exception.message.toString())
        }
        if(artistList.size<=0){
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}