package com.test.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.movieapp.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.apply {
            setupRecyclerView()
        }
    }

    private fun setupRecyclerView() {
    }

}