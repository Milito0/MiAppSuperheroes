package com.example.miappsuperhero.data

import com.example.miappsuperhero.data.database.dao.FavSuperheroDao
import com.example.miappsuperhero.data.database.entities.FavSuperheroIdEntity
import com.example.miappsuperhero.data.network.SuperheroService
import com.example.miappsuperhero.ui.domain.model.SuperheroDataItem
import com.example.miappsuperhero.ui.domain.model.SuperheroDetailItem
import com.example.miappsuperhero.ui.domain.model.toDomain
import javax.inject.Inject

class SuperheroRepository @Inject constructor(
    private val api: SuperheroService,
    private val favSuperheroDao: FavSuperheroDao
) {

    suspend fun getHeroesFromApi(superheroName: String) : SuperheroDataItem{
        return api.getSuperheroes(superheroName).toDomain()
    }

    suspend fun getHeroDetailsFromApi(superheroId: String): SuperheroDetailItem {
        return api.getSuperheroesDetail(superheroId).toDomain()
    }

    suspend fun getFavIdsFromDB(): List<FavSuperheroIdEntity>{
        return favSuperheroDao.getAllFavSuperheroes()
    }

    suspend fun insertFavSuperhero(favSuperhero:FavSuperheroIdEntity){
        favSuperheroDao.insertFavSuperhero(favSuperhero)
    }

    suspend fun removeFavSuperhero(id: String){
        favSuperheroDao.removeFavSuperhero(id)
    }

}