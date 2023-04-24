package com.example.miappsuperhero.data.model

import com.example.miappsuperhero.ui.domain.model.Biography
import com.example.miappsuperhero.ui.domain.model.PowerStats
import com.example.miappsuperhero.ui.domain.model.SuperheroImageDetail
import com.google.gson.annotations.SerializedName

data class SuperheroDetailModel(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStats,
    @SerializedName("image") val image: SuperheroImageDetail,
    @SerializedName("biography") val biography: Biography
)
