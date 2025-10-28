package com.arequipaexplorer.ui.detalle

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
class PlaceDetailViewModel @Inject constructor(
    private val placeRepository: PlaceRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(PlaceDetailUiState())
    val uiState: StateFlow<PlaceDetailUiState> = _uiState.asStateFlow()
    
    fun loadPlaceDetail(placeId: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            placeRepository.getPlaceById(placeId).collect { place ->
                _uiState.value = _uiState.value.copy(
                    place = place,
                    isLoading = false,
                    errorMessage = if (place == null) "Lugar no encontrado" else null
                )
            }
        }
    }
    
    fun toggleFavorite() {
        val currentPlace = _uiState.value.place ?: return
        val updatedPlace = currentPlace.copy(isFavorite = !currentPlace.isFavorite)
        
        _uiState.value = _uiState.value.copy(place = updatedPlace)
        
        // Aquí se implementaría la lógica para guardar en base de datos local
        // o enviar al servidor
    }
    
    fun sharePlace() {
        // Lógica para compartir el lugar
        val place = _uiState.value.place ?: return
        // Implementar compartir usando Intent
    }
}

data class PlaceDetailUiState(
    val place: Place? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)