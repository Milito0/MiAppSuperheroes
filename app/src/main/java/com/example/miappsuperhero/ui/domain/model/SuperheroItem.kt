package com.example.miappsuperhero.ui.domain.model

import com.example.miappsuperhero.data.model.SuperheroDataResponse
import com.google.gson.annotations.SerializedName

data class SuperheroDataItem(
    val response: String,
    val superheroes: List<SuperheroItem>?
)

data class SuperheroItem(
    @SerializedName("id") val superheroId: String,
    val name: String,
    val image: SuperheroImage,
    var isFav:Boolean = false
)

data class SuperheroImage(
    val url: String
)

fun SuperheroDataResponse.toDomain() = SuperheroDataItem(response, superheroes)
