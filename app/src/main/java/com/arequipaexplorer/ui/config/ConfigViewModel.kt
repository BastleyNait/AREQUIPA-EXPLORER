package com.arequipaexplorer.ui.config

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState = MutableStateFlow(ConfigUiState())
    val uiState: StateFlow<ConfigUiState> = _uiState.asStateFlow()
    
    fun toggleNotifications(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(notificationsEnabled = enabled)
        // Aquí se implementaría la lógica para guardar en SharedPreferences
    }
    
    fun toggleDarkMode(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(darkModeEnabled = enabled)
        // Aquí se implementaría la lógica para cambiar el tema
    }
    
    fun changeLanguage(language: String) {
        _uiState.value = _uiState.value.copy(selectedLanguage = language)
        // Aquí se implementaría la lógica para cambiar el idioma
    }
    
    fun clearCache() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            // Simular limpieza de caché
            kotlinx.coroutines.delay(1000)
            
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                cacheCleared = true
            )
        }
    }
    
    fun resetCacheClearedFlag() {
        _uiState.value = _uiState.value.copy(cacheCleared = false)
    }
}

data class ConfigUiState(
    val notificationsEnabled: Boolean = true,
    val darkModeEnabled: Boolean = false,
    val selectedLanguage: String = "Español",
    val isLoading: Boolean = false,
    val cacheCleared: Boolean = false
)