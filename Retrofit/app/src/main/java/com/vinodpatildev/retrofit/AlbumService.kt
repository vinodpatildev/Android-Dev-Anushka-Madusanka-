package com.vinodpatildev.retrofit

import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>

    @GET("/albums")
    suspend fun getSortedData(@Query("userId") userId:Int): Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") id:Int) : Response<AlbumsItem>

    @POST("/albums/")
    suspend fun uploadAlbum(@Body albumsItem: AlbumsItem) : Response<AlbumsItem>

}