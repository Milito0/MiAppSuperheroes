package com.example.miappsuperhero.ui.domain.model

import com.example.miappsuperhero.data.model.SuperheroDetailModel
import com.google.gson.annotations.SerializedName

data class SuperheroDetailItem(
    val name: String,
    val powerstats: PowerStats,
    val image: SuperheroImageDetail,
    val biography: Biography
)

data class PowerStats(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class SuperheroImageDetail(@SerializedName("url") val url: String)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String
)

fun SuperheroDetailModel.toDomain() = SuperheroDetailItem(name, powerstats, image, biography)
