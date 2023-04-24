package com.example.miappsuperhero.ui.domain

import com.example.miappsuperhero.data.SuperheroRepository
import com.example.miappsuperhero.ui.domain.model.SuperheroDetailItem
import javax.inject.Inject

class GetSuperheroDetail @Inject constructor(
    private val repository: SuperheroRepository
) {
    suspend operator fun invoke(superheroId: String): SuperheroDetailItem {
        return repository.getHeroDetailsFromApi(superheroId)
    }
}