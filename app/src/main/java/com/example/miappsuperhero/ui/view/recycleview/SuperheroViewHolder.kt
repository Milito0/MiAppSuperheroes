package com.example.miappsuperhero.ui.view.recycleview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.miappsuperhero.databinding.ItemSuperheroBinding
import com.example.miappsuperhero.ui.domain.model.SuperheroItem
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItem: SuperheroItem, onItemSelected: (String) -> Unit) {
        binding.tvSuperheroName.text = superheroItem.name

        Picasso.get().load(superheroItem.image.url).into(binding.ivSuperhero)


        binding.root.setOnClickListener{ onItemSelected(superheroItem.superheroId) }
    }

}