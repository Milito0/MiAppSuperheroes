package com.example.miappsuperhero.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miappsuperhero.ui.domain.GetSuperheroDetail
import com.example.miappsuperhero.ui.domain.model.SuperheroDetailItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailSuperheroViewModel @Inject constructor(
    private val getSuperheroDetail: GetSuperheroDetail
) : ViewModel() {

    val superheroDetail = MutableLiveData<SuperheroDetailItem>()

    fun postDetails(id: String){

        viewModelScope.launch {
            val result = getSuperheroDetail(id)
            superheroDetail.postValue(result)
        }
    }
}
