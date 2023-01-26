package com.vinodpatildev.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*


import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var retService: AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        getRequestWithQueryParameters()
        uploadAlbum()
    }




    fun getRequestWithQueryParameters(){
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getSortedData(3)
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val listAlbum = it.body()
            var result = ""
            listAlbum?.forEach({
                result += "Album id: ${it.id}\n User id: ${it.userId}\n Album Name: ${it.title} \n"

                result += "\n\n"
            })
            findViewById<TextView>(R.id.text_view).text = result
        })
    }
    fun getRequestWithPathParameters(){
        val pathResponse : LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }
        pathResponse.observe(this, Observer {
            Toast.makeText(this,it.body().toString(),Toast.LENGTH_LONG).show()
        })
    }
    fun uploadAlbum(){
        val uploadAlbumResponse : LiveData<Response<AlbumsItem>> = liveData {
            val albumsItem = AlbumsItem(0,"Vinod's Song",118)
            val uploadResponse = retService.uploadAlbum(albumsItem)
            emit(uploadResponse)
        }
        uploadAlbumResponse.observe(this, Observer {
            Toast.makeText(this, it.body().toString(), Toast.LENGTH_LONG).show()
        })
    }

}
