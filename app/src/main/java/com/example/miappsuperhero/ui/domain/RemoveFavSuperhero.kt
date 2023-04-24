package com.example.miappsuperhero.ui.domain

import com.example.miappsuperhero.data.SuperheroRepository
import com.example.miappsuperhero.data.database.entities.FavSuperheroIdEntity
import javax.inject.Inject

class RemoveFavSuperhero @Inject constructor(
    private val repository: SuperheroRepository
) {
    suspend operator fun invoke(favSuperhero: FavSuperheroIdEntity) {
        repository.insertFavSuperhero(favSuperhero)
    }
}