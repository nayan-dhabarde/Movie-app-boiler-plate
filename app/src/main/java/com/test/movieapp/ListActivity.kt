package com.test.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.movieapp.databinding.ActivityHomeBinding
import com.test.movieapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val viewModel by viewModels<HomeViewModel>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState == null) {
            viewModel.getMoviesWith("")
        }
        
        binding.apply {
            setupRecyclerView()
            searchEditText.doOnTextChanged { text, start, before, count ->    
                viewModel.getMoviesWith(text.toString())
            }
        }
    }

    private fun setupRecyclerView() {
        binding.apply { 
            movieRecyclerView.layoutManager = LinearLayoutManager(this)
        }
    }

}