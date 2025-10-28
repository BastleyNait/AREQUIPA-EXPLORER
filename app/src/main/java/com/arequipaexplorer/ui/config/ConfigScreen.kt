package com.arequipaexplorer.ui.config

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigScreen(
    viewModel: ConfigViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var showLanguageDialog by remember { mutableStateOf(false) }
    
    // Mostrar mensaje cuando se limpia el caché
    LaunchedEffect(uiState.cacheCleared) {
        if (uiState.cacheCleared) {
            // Aquí se podría mostrar un Snackbar
            viewModel.resetCacheClearedFlag()
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Configuración") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Sección de Notificaciones
            ConfigSection(title = "Notificaciones") {
                ConfigItem(
                    title = "Notificaciones",
                    subtitle = "Recibir notificaciones de la app",
                    trailing = {
                        Switch(
                            checked = uiState.notificationsEnabled,
                            onCheckedChange = viewModel::toggleNotifications
                        )
                    }
                )
            }
            
            HorizontalDivider()
            
            // Sección de Apariencia
            ConfigSection(title = "Apariencia") {
                ConfigItem(
                    title = "Modo Oscuro",
                    subtitle = "Cambiar entre tema claro y oscuro",
                    trailing = {
                        Switch(
                            checked = uiState.darkModeEnabled,
                            onCheckedChange = viewModel::toggleDarkMode
                        )
                    }
                )
                
                ConfigItem(
                    title = "Idioma",
                    subtitle = uiState.selectedLanguage,
                    onClick = { showLanguageDialog = true }
                )
            }
            
            HorizontalDivider()
            
            // Sección de Almacenamiento
            ConfigSection(title = "Almacenamiento") {
                ConfigItem(
                    title = "Limpiar Caché",
                    subtitle = "Liberar espacio eliminando archivos temporales",
                    onClick = viewModel::clearCache,
                    trailing = {
                        if (uiState.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(24.dp),
                                strokeWidth = 2.dp
                            )
                        }
                    }
                )
            }
            
            HorizontalDivider()
            
            // Sección de Información
            ConfigSection(title = "Información") {
                ConfigItem(
                    title = "Acerca de",
                    subtitle = "Versión 1.0.0"
                )
            }
        }
    }
    
    // Diálogo de selección de idioma
    if (showLanguageDialog) {
        LanguageSelectionDialog(
            currentLanguage = uiState.selectedLanguage,
            onLanguageSelected = { language ->
                viewModel.changeLanguage(language)
                showLanguageDialog = false
            },
            onDismiss = { showLanguageDialog = false }
        )
    }
}

@Composable
private fun ConfigSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.primary
        )
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ConfigItem(
    title: String,
    subtitle: String,
    onClick: (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null
) {
    ListItem(
        headlineContent = { Text(title) },
        supportingContent = { Text(subtitle) },
        trailingContent = trailing,
        modifier = if (onClick != null) {
            Modifier.clickable { onClick() }
        } else {
            Modifier
        }
    )
}

@Composable
private fun LanguageSelectionDialog(
    currentLanguage: String,
    onLanguageSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val languages = listOf("Español", "English", "Quechua")
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Seleccionar Idioma") },
        text = {
            Column {
                languages.forEach { language ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onLanguageSelected(language) }
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = language == currentLanguage,
                            onClick = { onLanguageSelected(language) }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(language)
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Cerrar")
            }
        }
    )
}