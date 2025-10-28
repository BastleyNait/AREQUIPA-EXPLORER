package com.arequipaexplorer.data.model

data class Place(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val category: String,
    val location: String,
    val rating: Float,
    val isFavorite: Boolean = false
)