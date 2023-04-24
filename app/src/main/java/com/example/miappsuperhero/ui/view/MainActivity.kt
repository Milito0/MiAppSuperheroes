package com.example.miappsuperhero.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miappsuperhero.databinding.ActivityMainBinding
import com.example.miappsuperhero.ui.view.recycleview.SuperheroAdapter
import com.example.miappsuperhero.ui.view.DetailSuperheroActivity.Companion.EXTRA_ID
import com.example.miappsuperhero.ui.viewmodel.SuperheroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SuperheroAdapter
    private val superheroViewModel: SuperheroViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniUI()

        superheroViewModel.superheroDataResponse.observe(this, Observer {
            //Log.i("Milito", it.toString())
            adapter.updateList(it)
            binding.progressBar.isVisible = false

        })
    }

    private fun iniUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.progressBar.isVisible = true
                superheroViewModel.getHeroes(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                binding.progressBar.isVisible = true
                superheroViewModel.getHeroes(query.orEmpty())
                return false
            }

        })
        adapter = SuperheroAdapter {
            Log.i("milito", it)
            navigateToDetail(it) }
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter


    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        Log.i("milito", id)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }


}