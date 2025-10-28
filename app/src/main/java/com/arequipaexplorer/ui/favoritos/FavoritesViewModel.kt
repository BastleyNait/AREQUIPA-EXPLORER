package com.arequipaexplorer.ui.favoritos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arequipaexplorer.data.model.Place
import com.arequipaexplorer.data.repository.PlaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val placeRepository: PlaceRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> = _uiState.asStateFlow()
    
    init {
        loadFavoritePlaces()
    }
    
    private fun loadFavoritePlaces() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            placeRepository.getFavoritePlaces().collect { favoritePlaces ->
                _uiState.value = _uiState.value.copy(
                    favoritePlaces = favoritePlaces,
                    isLoading = false
                )
            }
        }
    }
    
    fun removeFavorite(place: Place) {
        // Implementar lógica para remover de favoritos
        val updatedFavorites = _uiState.value.favoritePlaces.filter { it.id != place.id }
        _uiState.value = _uiState.value.copy(favoritePlaces = updatedFavorites)
    }
    
    fun clearAllFavorites() {
        _uiState.value = _uiState.value.copy(favoritePlaces = emptyList())
    }
}

data class FavoritesUiState(
    val favoritePlaces: List<Place> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)