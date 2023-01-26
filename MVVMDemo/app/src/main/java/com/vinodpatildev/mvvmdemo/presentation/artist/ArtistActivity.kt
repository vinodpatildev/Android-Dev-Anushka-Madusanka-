package com.vinodpatildev.mvvmdemo.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.vinodpatildev.mvvmdemo.R
import com.vinodpatildev.mvvmdemo.databinding.ActivityArtistBinding
import com.vinodpatildev.mvvmdemo.databinding.ActivityMovieBinding
import com.vinodpatildev.mvvmdemo.presentation.di.Injector
import com.vinodpatildev.mvvmdemo.presentation.movie.MovieAdapter
import com.vinodpatildev.mvvmdemo.presentation.movie.MovieViewModel
import com.vinodpatildev.mvvmdemo.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    private lateinit var artist_adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        initArtistRecyclerView()
    }

    private fun initArtistRecyclerView() {
         binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        artist_adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = artist_adapter
        displayArtistsInRecyclerView()
    }

    private fun displayArtistsInRecyclerView() {
        val responseLiveData = artistViewModel.getArtist()
        binding.artistProgressBar.visibility = View.VISIBLE
        responseLiveData.observe(this, Observer {movies->
            if(movies != null){
                binding.artistProgressBar.visibility = View.GONE
                artist_adapter.setArtistList(movies!!)
                artist_adapter.notifyDataSetChanged()
            }else{
                Snackbar.make(binding.root,"No artist found.", Snackbar.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.menu.update -> {
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtist()
        response.observe(this) {
            if (it != null) {
                binding.artistProgressBar.visibility = View.GONE
                artist_adapter.setArtistList(it)
                artist_adapter.notifyDataSetChanged()
            } else {
                Snackbar.make(binding.root, "No artists found.", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}