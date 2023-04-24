package com.example.miappsuperhero.data.network

import com.example.miappsuperhero.data.model.SuperheroDataResponse
import com.example.miappsuperhero.data.model.SuperheroDetailModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SuperheroService @Inject constructor(private val api: ApiService) {

    suspend fun getSuperheroes(superheroName: String): SuperheroDataResponse {
        return withContext(Dispatchers.IO){
            val response = api.getSuperheroes(superheroName)
            response.body()!!
        }
    }

    suspend fun getSuperheroesDetail(superheroId: String): SuperheroDetailModel {
        return withContext(Dispatchers.IO){
            val response = api.getSuperheroDetail(superheroId)
            response.body()!!
        }
    }
}