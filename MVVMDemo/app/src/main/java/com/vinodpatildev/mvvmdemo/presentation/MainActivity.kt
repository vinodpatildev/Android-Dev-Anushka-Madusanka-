package com.vinodpatildev.mvvmdemo.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.databinding.DataBindingUtil
import com.vinodpatildev.mvvmdemo.R
import com.vinodpatildev.mvvmdemo.databinding.ActivityMainBinding
import com.vinodpatildev.mvvmdemo.presentation.artist.ArtistActivity
import com.vinodpatildev.mvvmdemo.presentation.movie.MovieActivity
import com.vinodpatildev.mvvmdemo.presentation.tvshow.TvShowActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnMovies.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.btnTvShows.setOnClickListener{
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        binding.btnArtists.setOnClickListener{
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}