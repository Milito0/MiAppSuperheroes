package com.example.miappsuperhero.di

import android.content.Context
import androidx.room.Room
import com.example.miappsuperhero.data.database.SuperheroDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DB_NAME = "SuperheroDB"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, SuperheroDB::class.java, DB_NAME).build()


    @Singleton
    @Provides
    fun provideFavSuperheroDao(db:SuperheroDB) = db.getFavSuperheroDao()
}