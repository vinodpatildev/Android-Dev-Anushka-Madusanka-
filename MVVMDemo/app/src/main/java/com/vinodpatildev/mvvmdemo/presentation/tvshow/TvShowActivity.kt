package com.vinodpatildev.mvvmdemo.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.vinodpatildev.mvvmdemo.R
import com.vinodpatildev.mvvmdemo.data.model.artist.Artist
import com.vinodpatildev.mvvmdemo.databinding.ActivityTvShowBinding
import com.vinodpatildev.mvvmdemo.presentation.artist.ArtistAdapter
import com.vinodpatildev.mvvmdemo.presentation.artist.ArtistViewModel
import com.vinodpatildev.mvvmdemo.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTvShowBinding
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent()
            .inject(this)
        tvShowViewModel = ViewModelProvider(this,factory).get(TvShowViewModel::class.java)
        initRvShowRecyclerView()
    }

    private fun initRvShowRecyclerView() {
        binding.tvshowRecyclerView.layoutManager = LinearLayoutManager(this)
        tvShowAdapter = TvShowAdapter()
        binding.tvshowRecyclerView.adapter = tvShowAdapter

        displayTvShowsInRecyclerView()
    }

    private fun displayTvShowsInRecyclerView() {
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer{tvshows->
            if(tvshows != null){
                binding.tvshowProgressBar.visibility = View.GONE
                tvShowAdapter.setTvShowList(tvshows)
                tvShowAdapter.notifyDataSetChanged()
            }else{
                Snackbar.make(binding.root, "Not tv shows found.", Snackbar.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update ->{
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows() {
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShows()
        response.observe(this) {
            if (it != null) {
                binding.tvshowProgressBar.visibility = View.GONE
                tvShowAdapter.setTvShowList(it)
                tvShowAdapter.notifyDataSetChanged()
            } else {
                Snackbar.make(binding.root, "No tv shows found.", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}