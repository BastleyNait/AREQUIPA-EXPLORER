package com.arequipaexplorer.ui.home

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
class HomeViewModel @Inject constructor(
    private val placeRepository: PlaceRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    init {
        loadFeaturedPlaces()
    }
    
    private fun loadFeaturedPlaces() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            placeRepository.getAllPlaces().collect { places ->
                _uiState.value = _uiState.value.copy(
                    featuredPlaces = places.take(3), // Mostrar solo 3 lugares destacados
                    isLoading = false
                )
            }
        }
    }
    
    fun onPlaceClick(place: Place) {
        // Navegación será manejada en el composable
    }
}

data class HomeUiState(
    val featuredPlaces: List<Place> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)