package com.example.miappsuperhero.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.miappsuperhero.data.database.entities.FavSuperheroIdEntity

@Dao
interface FavSuperheroDao {

    @Query("SELECT * FROM fav_table")
    suspend fun getAllFavSuperheroes(): List<FavSuperheroIdEntity>

    @Insert()
    suspend fun insertFavSuperhero(favSuperheroIdEntity: FavSuperheroIdEntity)

    @Query("DELETE FROM fav_table WHERE idFavSuperhero = :idFav")
    suspend fun removeFavSuperhero(idFav: String)
}