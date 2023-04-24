package com.example.miappsuperhero.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.miappsuperhero.data.database.dao.FavSuperheroDao
import com.example.miappsuperhero.data.database.entities.FavSuperheroIdEntity

@Database(entities = [FavSuperheroIdEntity::class], version = 1)
abstract class SuperheroDB: RoomDatabase() {

    abstract fun getFavSuperheroDao(): FavSuperheroDao
}