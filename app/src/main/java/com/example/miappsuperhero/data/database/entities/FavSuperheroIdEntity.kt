package com.example.miappsuperhero.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.miappsuperhero.ui.domain.model.SuperheroItem

@Entity(tableName = "fav_table")
data class FavSuperheroIdEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id") val id: Int = 0,
    @ColumnInfo(name = "idFavSuperhero") val idFavSuperhero: String
)

fun SuperheroItem.toDatabase() = FavSuperheroIdEntity(idFavSuperhero = superheroId)