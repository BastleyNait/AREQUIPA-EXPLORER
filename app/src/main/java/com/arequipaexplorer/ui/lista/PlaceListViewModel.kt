package com.arequipaexplorer.ui.lista

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
class PlaceListViewModel @Inject constructor(
    private val placeRepository: PlaceRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(PlaceListUiState())
    val uiState: StateFlow<PlaceListUiState> = _uiState.asStateFlow()
    
    init {
        loadAllPlaces()
    }
    
    private fun loadAllPlaces() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            placeRepository.getAllPlaces().collect { places ->
                _uiState.value = _uiState.value.copy(
                    places = places,
                    filteredPlaces = places,
                    isLoading = false
                )
            }
        }
    }
    
    fun onSearchQueryChanged(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
        
        if (query.isBlank()) {
            _uiState.value = _uiState.value.copy(
                filteredPlaces = _uiState.value.places
            )
        } else {
            viewModelScope.launch {
                placeRepository.searchPlaces(query).collect { searchResults ->
                    _uiState.value = _uiState.value.copy(
                        filteredPlaces = searchResults
                    )
                }
            }
        }
    }
    
    fun onCategoryFilterChanged(category: String?) {
        _uiState.value = _uiState.value.copy(selectedCategory = category)
        
        val filteredByCategory = if (category == null) {
            _uiState.value.places
        } else {
            _uiState.value.places.filter { it.category == category }
        }
        
        _uiState.value = _uiState.value.copy(filteredPlaces = filteredByCategory)
    }
    
    fun getCategories(): List<String> {
        return _uiState.value.places.map { it.category }.distinct()
    }
}

data class PlaceListUiState(
    val places: List<Place> = emptyList(),
    val filteredPlaces: List<Place> = emptyList(),
    val searchQuery: String = "",
    val selectedCategory: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)