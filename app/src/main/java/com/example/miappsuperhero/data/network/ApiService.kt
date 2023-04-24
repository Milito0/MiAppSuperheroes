package com.example.miappsuperhero.data.network

import com.example.miappsuperhero.data.model.SuperheroDataResponse
import com.example.miappsuperhero.data.model.SuperheroDetailModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/1772384446554478/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String):Response<SuperheroDataResponse>

    @GET("/api/1772384446554478/{character-id}")
    suspend fun getSuperheroDetail(@Path("character-id") superheroId:String):Response<SuperheroDetailModel>
}