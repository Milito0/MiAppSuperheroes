package com.example.miappsuperhero.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.miappsuperhero.databinding.ActivityDetailSuperheroBinding
import com.example.miappsuperhero.ui.domain.model.PowerStats
import com.example.miappsuperhero.ui.domain.model.SuperheroDetailItem
import com.example.miappsuperhero.ui.viewmodel.DetailSuperheroViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class DetailSuperheroActivity  : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityDetailSuperheroBinding
    private val superheroDetails: DetailSuperheroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        Log.i("milito", id)

        superheroDetails.postDetails(id)

        superheroDetails.superheroDetail.observe(this, Observer {
            createUI(it)
        })
    }


    private fun createUI(superhero: SuperheroDetailItem) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero)
        binding.tvSuperheroName.text = superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperheroRealName.text = superhero.biography.fullName
        if(superhero.biography.publisher == "null") binding.tvPublisher.text = "Sin publisher"
        else binding.tvPublisher.text = superhero.biography.publisher
    }

    private fun prepareStats(powerstats: PowerStats) {

        updateHeight(binding.viewCombat, powerstats.combat)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewStrenght, powerstats.strength)
    }

    private fun updateHeight(view: View, stat: String) {
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToDp(px: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics)
            .roundToInt()
    }
}