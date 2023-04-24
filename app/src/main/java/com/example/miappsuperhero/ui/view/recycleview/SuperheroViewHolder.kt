package com.example.miappsuperhero.ui.view.recycleview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.miappsuperhero.R
import com.example.miappsuperhero.databinding.ItemSuperheroBinding
import com.example.miappsuperhero.ui.domain.model.SuperheroItem
import com.squareup.picasso.Picasso
import javax.inject.Inject

class SuperheroViewHolder (view: View) : RecyclerView.ViewHolder(view) {


    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItem: SuperheroItem, onItemSelected: (String) -> Unit, addFavSuperhero: (SuperheroItem) -> Unit) {
        binding.tvSuperheroName.text = superheroItem.name

        Picasso.get().load(superheroItem.image.url).into(binding.ivSuperhero)

        binding.favIcon.setOnClickListener {
            if (!superheroItem.isFav) {
                binding.favIcon.setImageResource(R.drawable.ic_star_fav)
                addFavSuperhero(superheroItem)
                superheroItem.isFav = !superheroItem.isFav
            } else {
                binding.favIcon.setImageResource(R.drawable.ic_start_border)
                superheroItem.isFav = !superheroItem.isFav
            }
        }
        binding.root.setOnClickListener { onItemSelected(superheroItem.superheroId) }
    }

}