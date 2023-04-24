package com.example.miappsuperhero.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miappsuperhero.data.database.entities.toDatabase
import com.example.miappsuperhero.ui.domain.GetSuperheroes
import com.example.miappsuperhero.ui.domain.InsertFavSuperhero
import com.example.miappsuperhero.ui.domain.model.SuperheroItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor(
    private val getSuperhero: GetSuperheroes,
    private val insertFavSuperhero: InsertFavSuperhero
) : ViewModel() {

    val superheroDataResponse = MutableLiveData<List<SuperheroItem>>()

    fun getHeroes(heroName: String) {
        viewModelScope.launch {
            val result = getSuperhero(heroName)
            if (result.response == "error") {
                superheroDataResponse.postValue(emptyList())
            } else {
                superheroDataResponse.postValue(result.superheroes!!)
            }
        }
    }

    fun addFavSuperhero(superheroItem: SuperheroItem){
        viewModelScope.launch {
            insertFavSuperhero(superheroItem.toDatabase())
        }
    }

    fun removeFavSuperhero(superheroId: String){
        viewModelScope.launch {

        }
    }



}