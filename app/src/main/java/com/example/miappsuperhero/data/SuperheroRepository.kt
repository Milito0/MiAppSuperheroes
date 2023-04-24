package com.example.miappsuperhero.data

import com.example.miappsuperhero.data.network.SuperheroService
import com.example.miappsuperhero.ui.domain.model.SuperheroDataItem
import com.example.miappsuperhero.ui.domain.model.SuperheroDetailItem
import com.example.miappsuperhero.ui.domain.model.toDomain
import javax.inject.Inject

class SuperheroRepository @Inject constructor(
    private val api: SuperheroService
) {

    suspend fun getHeroesFromApi(superheroName: String) : SuperheroDataItem{
        return api.getSuperheroes(superheroName).toDomain()
    }

    suspend fun getHeroDetailsFromApi(superheroId: String): SuperheroDetailItem {
        return api.getSuperheroesDetail(superheroId).toDomain()
    }

}