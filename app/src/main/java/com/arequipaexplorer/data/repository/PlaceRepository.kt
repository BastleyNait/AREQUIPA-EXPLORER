package com.arequipaexplorer.data.repository

import com.arequipaexplorer.data.model.Place
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceRepository @Inject constructor() {
    
    // Datos de ejemplo para lugares turísticos de Arequipa
    private val samplePlaces = listOf(
        Place(
            id = 1,
            name = "Cañón del Colca",
            description = "Uno de los cañones más profundos del mundo",
            imageUrl = "",
            category = "Naturaleza",
            location = "Arequipa, Perú",
            rating = 4.8f
        ),
        Place(
            id = 2,
            name = "Monasterio de Santa Catalina",
            description = "Histórico monasterio colonial",
            imageUrl = "",
            category = "Historia",
            location = "Centro Histórico, Arequipa",
            rating = 4.6f
        ),
        Place(
            id = 3,
            name = "Plaza de Armas",
            description = "Plaza principal de la ciudad blanca",
            imageUrl = "",
            category = "Cultura",
            location = "Centro Histórico, Arequipa",
            rating = 4.5f
        ),
        Place(
            id = 4,
            name = "Volcán Misti",
            description = "Volcán emblemático de Arequipa",
            imageUrl = "",
            category = "Naturaleza",
            location = "Arequipa, Perú",
            rating = 4.7f
        )
    )
    
    fun getAllPlaces(): Flow<List<Place>> {
        return flowOf(samplePlaces)
    }
    
    fun getPlaceById(id: Int): Flow<Place?> {
        return flowOf(samplePlaces.find { it.id == id })
    }
    
    fun getFavoritePlaces(): Flow<List<Place>> {
        return flowOf(samplePlaces.filter { it.isFavorite })
    }
    
    fun searchPlaces(query: String): Flow<List<Place>> {
        return flowOf(
            samplePlaces.filter { 
                it.name.contains(query, ignoreCase = true) ||
                it.description.contains(query, ignoreCase = true) ||
                it.category.contains(query, ignoreCase = true)
            }
        )
    }
}