package com.example.miappsuperhero.ui.domain

import com.example.miappsuperhero.data.SuperheroRepository
import com.example.miappsuperhero.ui.domain.model.SuperheroDataItem
import javax.inject.Inject

class GetSuperheroes @Inject constructor(
    private val repository: SuperheroRepository
){

    suspend operator fun invoke(superheroName: String): SuperheroDataItem {
        return repository.getHeroesFromApi(superheroName)
    }


}