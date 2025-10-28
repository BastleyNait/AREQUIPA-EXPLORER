package com.arequipaexplorer.di

import com.arequipaexplorer.data.repository.PlaceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun providePlaceRepository(): PlaceRepository {
        return PlaceRepository()
    }
}