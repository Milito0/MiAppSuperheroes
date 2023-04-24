package com.example.miappsuperhero.ui.view.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miappsuperhero.R
import com.example.miappsuperhero.ui.domain.model.SuperheroItem
import javax.inject.Inject

class SuperheroAdapter @Inject constructor(
    private var superheroList: List<SuperheroItem> = emptyList(),
    private val onItemSelected: (String) -> Unit,
    private val addFavSuperhero: (SuperheroItem) -> Unit
) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroList: List<SuperheroItem>) {
        this.superheroList = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperheroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun getItemCount() = superheroList.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(superheroList[position], onItemSelected, addFavSuperhero)
    }

}