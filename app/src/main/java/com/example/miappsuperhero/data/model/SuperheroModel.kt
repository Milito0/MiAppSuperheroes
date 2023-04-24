package com.example.miappsuperhero.data.model

import com.example.miappsuperhero.ui.domain.model.SuperheroItem
import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItem>
)



