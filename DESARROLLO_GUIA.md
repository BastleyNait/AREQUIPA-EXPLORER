# 📱 Guía de Desarrollo - Arequipa Explorer

## 🏗️ Arquitectura del Proyecto

Este proyecto utiliza **MVVM (Model-View-ViewModel)** con **Jetpack Compose** y **Hilt** para inyección de dependencias.

### 📁 Estructura de Carpetas
```
app/src/main/java/com/arequipaexplorer/
├── data/
│   ├── model/           # Modelos de datos
│   └── repository/      # Repositorios
├── di/                  # Inyección de dependencias
├── navigation/          # Sistema de navegación
├── ui/
│   ├── home/           # Pantalla principal
│   ├── lista/          # Lista de lugares
│   ├── detalle/        # Detalle de lugar
│   ├── favoritos/      # Lugares favoritos
│   ├── config/         # Configuración
│   └── theme/          # Temas y estilos
└── viewmodel/          # ViewModels compartidos
```

---

## 👥 Asignación de Desarrolladores

### 🏠 **Rodrigo - HomeScreen (Inicio)**
**Branch asignado:** `Inicio-Rodrigo`
**Archivos asignados:**
- `ui/home/HomeScreen.kt` ✅ (Base creada)

**QUÉ PUEDES TOCAR:**
- ✅ Modificar el contenido visual de `HomeScreen.kt`
- ✅ Agregar nuevos componentes UI dentro de `HomeScreenContent`
- ✅ Cambiar colores, textos y estilos
- ✅ Agregar animaciones y transiciones

**QUÉ NO DEBES TOCAR:**
- ❌ `HomeViewModel.kt` (lógica de negocio)
- ❌ Archivos de navegación (`AppNavigation.kt`, `Screen.kt`)
- ❌ Repositorios y modelos de datos
- ❌ Configuración de Hilt

---

### 📋 **Joe - PlaceListScreen (Lista de Lugares)**
**Branch asignado:** `Lista-de-lugares-Joe`
**Archivos asignados:**
- `ui/lista/PlaceListScreen.kt` ✅ (Base creada)

**QUÉ PUEDES TOCAR:**
- ✅ Modificar el contenido visual de `PlaceListScreen.kt`
- ✅ Personalizar `PlaceListItem` y `PlaceGrid`
- ✅ Cambiar el diseño de la lista/grid
- ✅ Agregar filtros visuales y animaciones

**QUÉ NO DEBES TOCAR:**
- ❌ `PlaceListViewModel.kt` (lógica de negocio)
- ❌ Funciones de navegación (`onPlaceClick`)
- ❌ Estados del ViewModel (`uiState`)

---

### 🔍 **Sebastian - PlaceDetailScreen (Detalle del Lugar)**
**Branch asignado:** `Detalle-del-Lugar-Sebastian`
**Archivos asignados:**
- `ui/detalle/PlaceDetailScreen.kt` ✅ (Base creada)

**QUÉ PUEDES TOCAR:**
- ✅ Modificar `PlaceDetailContent`
- ✅ Personalizar el diseño de detalles
- ✅ Agregar más información visual
- ✅ Mejorar la presentación de imágenes

**QUÉ NO DEBES TOCAR:**
- ❌ `PlaceDetailViewModel.kt` (lógica de negocio)
- ❌ Funciones de navegación (`onNavigateBack`)
- ❌ Lógica de favoritos (se maneja en ViewModel)

---

### ⭐ **Misael - FavoritesScreen (Favoritos)**
**Branch asignado:** `Favoritos-Misael`
**Archivos asignados:**
- `ui/favoritos/FavoritesScreen.kt` ✅ (Base creada)

**QUÉ PUEDES TOCAR:**
- ✅ Modificar el contenido visual de `FavoritesScreen.kt`
- ✅ Personalizar `FavoritesList`
- ✅ Cambiar el diseño de elementos favoritos
- ✅ Agregar animaciones de eliminación

**QUÉ NO DEBES TOCAR:**
- ❌ `FavoritesViewModel.kt` (lógica de negocio)
- ❌ Funciones de navegación
- ❌ Lógica de eliminación de favoritos

---

### ⚙️ **Daniel - ConfigScreen (Configuración y Notificaciones)**
**Branch asignado:** `Configuración-y-Notificaciones-Daniel`
**Archivos asignados:**
- `ui/config/ConfigScreen.kt` ✅ (Base creada)

**QUÉ PUEDES TOCAR:**
- ✅ Modificar el contenido visual de `ConfigScreen.kt`
- ✅ Personalizar `ConfigItem`
- ✅ Agregar nuevas opciones de configuración
- ✅ Cambiar el diseño de la lista de configuración

**QUÉ NO DEBES TOCAR:**
- ❌ `ConfigViewModel.kt` (lógica de negocio)
- ❌ Funciones de navegación
- ❌ Lógica de persistencia de configuración

---

## 🔄 Flujo de Trabajo

### 📝 **Antes de Empezar**
1. **Hacer pull** del branch `main` o `develop`
2. **Crear tu branch asignado** según tu pantalla:
   ```bash
   # Rodrigo (HomeScreen)
   git checkout -b Inicio-Rodrigo
   
   # Joe (PlaceListScreen)
   git checkout -b Lista-de-lugares-Joe
   
   # Sebastian (PlaceDetailScreen)
   git checkout -b Detalle-del-Lugar-Sebastian
   
   # Misael (FavoritesScreen)
   git checkout -b Favoritos-Misael
   
   # Daniel (ConfigScreen)
   git checkout -b Configuración-y-Notificaciones-Daniel
   ```
3. **Revisar tu archivo asignado** y entender la estructura base

### 💻 **Durante el Desarrollo**
1. **Solo modifica tu archivo asignado**
2. **Prueba frecuentemente** con `./gradlew build`
3. **No cambies imports** relacionados con ViewModels o navegación
4. **Mantén el patrón de naming** existente

### ✅ **Después de Terminar tu Vista**

#### 1. **Verificación Local**
```bash
# Compilar el proyecto
./gradlew build

# Ejecutar tests (si existen)
./gradlew test

# Instalar en dispositivo/emulador
./gradlew installDebug
```

#### 2. **Commit y Push**
```bash
# Agregar cambios
git add .

# Commit con mensaje descriptivo (ejemplos por desarrollador)
# Rodrigo:
git commit -m "feat: implementar diseño de HomeScreen con animaciones"

# Joe:
git commit -m "feat: implementar lista de lugares con filtros"

# Sebastian:
git commit -m "feat: implementar pantalla de detalle con galería"

# Misael:
git commit -m "feat: implementar pantalla de favoritos con animaciones"

# Daniel:
git commit -m "feat: implementar configuración y notificaciones"

# Push a tu branch asignado
git push origin [tu-branch-asignado]
```

#### 3. **Pull Request**
- Crear PR hacia `develop`
- **Título**: `[PANTALLA] Descripción breve`
- **Descripción**: Incluir screenshots y cambios realizados
- **Asignar** para revisión

#### 4. **Checklist de PR**
- [ ] ✅ Compila sin errores
- [ ] ✅ No hay warnings críticos
- [ ] ✅ La navegación funciona correctamente
- [ ] ✅ Responsive en diferentes tamaños de pantalla
- [ ] ✅ Sigue las guías de Material Design 3

---

## 🚫 **Reglas Importantes**

### ❌ **NUNCA Toques:**
- `MainActivity.kt`
- `ArequipaExplorerApplication.kt`
- Archivos en `di/` (inyección de dependencias)
- Archivos en `data/` (modelos y repositorios)
- Archivos en `navigation/`
- ViewModels que no sean de tu pantalla
- `AndroidManifest.xml`
- Archivos de configuración (`build.gradle.kts`, etc.)

### ✅ **SÍ Puedes:**
- Agregar nuevos composables en tu archivo
- Crear archivos de utilidades UI específicas para tu pantalla
- Modificar colores y estilos (pero mantén consistencia)
- Agregar animaciones y transiciones
- Mejorar la accesibilidad

---

## 🎨 **Guías de Diseño**

### 🎯 **Material Design 3**
- Usar componentes de `androidx.compose.material3`
- Seguir las guías de color y tipografía definidas
- Mantener consistencia visual entre pantallas

### 📱 **Responsive Design**
- Probar en diferentes tamaños de pantalla
- Usar `Modifier.fillMaxWidth()` apropiadamente
- Considerar orientación landscape

### ♿ **Accesibilidad**
- Agregar `contentDescription` a imágenes
- Usar `semantics` para elementos interactivos
- Mantener contraste adecuado

---

## 🆘 **Resolución de Problemas**

### 🔧 **Errores Comunes**

#### "Unresolved reference"
- Verificar imports
- Limpiar proyecto: `./gradlew clean`

#### "Smart cast is impossible"
- Usar `!!` cuando estés seguro que no es null
- O crear variable local: `val item = uiState.item`

#### Errores de compilación
1. `./gradlew clean`
2. `./gradlew build`
3. Si persiste, revisar imports y sintaxis

### 📞 **Contacto**
- **Dudas técnicas**: Crear issue en el repositorio
- **Problemas de merge**: Contactar al tech lead
- **Revisión de código**: Asignar PR al equipo

---

## 📚 **Recursos Útiles**

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Material Design 3](https://m3.material.io/)
- [Hilt Documentation](https://dagger.dev/hilt/)
- [MVVM Pattern](https://developer.android.com/topic/architecture)

---

**¡Feliz desarrollo! 🚀**