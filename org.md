# Arequipa Explorer - Guía Completa del Proyecto

## 📁 ESTRUCTURA COMPLETA DEL PROYECTO

```
ArequipaExplorer/
├── .gitignore
├── .idea/                          # IntelliJ/Android Studio config (NO TOCAR)
├── app/
│   ├── build.gradle.kts           # Dependencias (SOLO LÍDER)
│   ├── proguard-rules.pro
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml    # Permisos (SOLO LÍDER)
│       │   ├── java/com/arequipaexplorer/
│       │   │   ├── MainActivity.kt    # ⚠️ COMPARTIDO
│       │   │   │
│       │   │   ├── data/             # 📊 DATOS
│       │   │   │   ├── model/        # ⚠️ COMPARTIDO
│       │   │   │   │   ├── Lugar.kt
│       │   │   │   │   ├── Usuario.kt
│       │   │   │   │   ├── Categoria.kt
│       │   │   │   │   └── Reserva.kt
│       │   │   │   │
│       │   │   │   ├── repository/   # ⚠️ COMPARTIDO
│       │   │   │   │   ├── LugarRepository.kt
│       │   │   │   │   ├── UsuarioRepository.kt
│       │   │   │   │   └── FavoritosRepository.kt
│       │   │   │   │
│       │   │   │   └── local/        # Base de datos local
│       │   │   │       └── AppDatabase.kt
│       │   │   │
│       │   │   ├── ui/               # 🎨 INTERFACES
│       │   │   │   ├── theme/        # ⚠️ COMPARTIDO
│       │   │   │   │   ├── Color.kt
│       │   │   │   │   ├── Theme.kt
│       │   │   │   │   └── Type.kt
│       │   │   │   │
│       │   │   │   ├── components/   # ⚠️ COMPARTIDO
│       │   │   │   │   ├── LugarCard.kt
│       │   │   │   │   ├── BottomNavigationBar.kt
│       │   │   │   │   ├── TopAppBar.kt
│       │   │   │   │   ├── SearchBar.kt
│       │   │   │   │   └── FilterChip.kt
│       │   │   │   │
│       │   │   │   ├── home/         # 🏠 RODRIGO
│       │   │   │   │   ├── HomeScreen.kt
│       │   │   │   │   ├── HomeViewModel.kt
│       │   │   │   │   └── components/
│       │   │   │   │       ├── RecommendationSection.kt
│       │   │   │   │       └── CategoryFilter.kt
│       │   │   │   │
│       │   │   │   ├── search/       # 🔍 (Sin asignar)
│       │   │   │   │   ├── SearchScreen.kt
│       │   │   │   │   └── SearchViewModel.kt
│       │   │   │   │
│       │   │   │   ├── detalle/      # 📍 SEBASTIAN
│       │   │   │   │   ├── DetalleScreen.kt
│       │   │   │   │   ├── DetalleViewModel.kt
│       │   │   │   │   └── components/
│       │   │   │   │       ├── ImageGallery.kt
│       │   │   │   │       ├── InfoSection.kt
│       │   │   │   │       └── ReservaButton.kt
│       │   │   │   │
│       │   │   │   ├── favoritos/    # ❤️ MISAEL
│       │   │   │   │   ├── FavoritosScreen.kt
│       │   │   │   │   ├── FavoritosViewModel.kt
│       │   │   │   │   └── components/
│       │   │   │   │       └── FavoritoItem.kt
│       │   │   │   │
│       │   │   │   ├── lista/        # 📋 JOE
│       │   │   │   │   ├── ListaLugaresScreen.kt
│       │   │   │   │   ├── ListaLugaresViewModel.kt
│       │   │   │   │   └── components/
│       │   │   │   │       └── LugarListItem.kt
│       │   │   │   │
│       │   │   │   └── config/       # ⚙️ DANIEL
│       │   │   │       ├── ConfigScreen.kt
│       │   │   │       ├── ConfigViewModel.kt
│       │   │   │       └── components/
│       │   │   │           ├── NotificationSettings.kt
│       │   │   │           └── PreferenceItem.kt
│       │   │   │
│       │   │   ├── navigation/       # ⚠️ COMPARTIDO
│       │   │   │   ├── Screen.kt
│       │   │   │   └── NavGraph.kt
│       │   │   │
│       │   │   └── utils/            # ⚠️ COMPARTIDO
│       │   │       ├── Constants.kt
│       │   │       └── Extensions.kt
│       │   │
│       │   └── res/                  # Recursos
│       │       ├── drawable/         # Imágenes
│       │       ├── values/
│       │       │   ├── strings.xml   # ⚠️ COMPARTIDO
│       │       │   └── colors.xml    # ⚠️ COMPARTIDO
│       │       └── mipmap/           # Iconos de la app
│       │
│       └── test/                     # Tests unitarios
│
├── gradle/
│   └── wrapper/
├── build.gradle.kts                  # ⚠️ SOLO LÍDER
├── gradle.properties
├── settings.gradle.kts               # ⚠️ SOLO LÍDER
├── gradlew
├── gradlew.bat
├── README.md                         # Documentación
└── CONTRIBUTING.md                   # Guía de contribución

```

---

## 👥 DIVISIÓN DE TRABAJO

### 🏠 RODRIGO - PANTALLA HOME/INICIO

#### ✅ PUEDE TOCAR:
```
✓ app/src/main/java/com/arequipaexplorer/ui/home/
  ├── HomeScreen.kt
  ├── HomeViewModel.kt
  └── components/
      ├── RecommendationSection.kt
      └── CategoryFilter.kt
```

#### ❌ NO PUEDE TOCAR:
```
✗ ui/theme/
✗ ui/components/ (compartidos)
✗ navigation/
✗ data/model/
✗ MainActivity.kt
```

#### 📝 RESPONSABILIDADES:
- Pantalla principal con búsqueda
- Filtros de categorías (Todos, Cultura, Naturaleza, Comida, etc.)
- Sección de recomendaciones
- Navegación a detalle al hacer clic en un lugar
- Mostrar imagen destacada (Cañón del Colca)

#### 🔗 DEPENDENCIAS:
- Usa `LugarCard` de components (ya existe)
- Usa `BottomNavigationBar` de components
- Navega a detalle con: `navController.navigate("detalle/${lugarId}")`

---

### 📍 SEBASTIAN - DETALLE DEL LUGAR

#### ✅ PUEDE TOCAR:
```
✓ app/src/main/java/com/arequipaexplorer/ui/detalle/
  ├── DetalleScreen.kt
  ├── DetalleViewModel.kt
  └── components/
      ├── ImageGallery.kt
      ├── InfoSection.kt
      └── ReservaButton.kt
```

#### ❌ NO PUEDE TOCAR:
```
✗ ui/theme/
✗ ui/components/ (compartidos)
✗ navigation/
✗ data/model/
```

#### 📝 RESPONSABILIDADES:
- Galería de imágenes del lugar
- Información detallada (descripción, categoría, precio)
- Valoración con estrellas
- Botón de reservar (S/ 145.00)
- Botón compartir
- Botón eliminar/agregar a favoritos
- Información "Acerca del lugar"
- "Detalles Clave" con íconos

#### 🔗 DEPENDENCIAS:
- Recibe `lugarId` desde navegación
- Botón favoritos actualiza `FavoritosRepository`
- Botón compartir usa Intent de Android

---

### ❤️ MISAEL - FAVORITOS

#### ✅ PUEDE TOCAR:
```
✓ app/src/main/java/com/arequipaexplorer/ui/favoritos/
  ├── FavoritosScreen.kt
  ├── FavoritosViewModel.kt
  └── components/
      └── FavoritoItem.kt
```

#### ❌ NO PUEDE TOCAR:
```
✗ ui/theme/
✗ ui/components/ (compartidos)
✗ navigation/
✗ data/model/
✗ data/repository/FavoritosRepository.kt (SOLO LEER)
```

#### 📝 RESPONSABILIDADES:
- Lista de lugares favoritos
- Eliminar de favoritos
- Navegación a detalle
- Mostrar estado vacío si no hay favoritos
- Bottom navigation activo en "Favoritos"

#### 🔗 DEPENDENCIAS:
- Lee datos de `FavoritosRepository`
- Usa `LugarCard` o crea tu propio `FavoritoItem`
- Navega a detalle con: `navController.navigate("detalle/${lugarId}")`

---

### 📋 JOE - LISTA DE LUGARES

#### ✅ PUEDE TOCAR:
```
✓ app/src/main/java/com/arequipaexplorer/ui/lista/
  ├── ListaLugaresScreen.kt
  ├── ListaLugaresViewModel.kt
  └── components/
      └── LugarListItem.kt
```

#### ❌ NO PUEDE TOCAR:
```
✗ ui/theme/
✗ ui/components/ (compartidos)
✗ navigation/
✗ data/model/
```

#### 📝 RESPONSABILIDADES:
- Lista completa de lugares turísticos
- Filtros por categoría (tabs: Todos, Cultura, Naturaleza, Comida, Turfe)
- Cada item muestra: imagen, nombre, descripción corta, categoría, precio
- Botón de favorito en cada card
- Navegación a detalle

#### 🔗 DEPENDENCIAS:
- Lee datos de `LugarRepository`
- Puede usar `LugarCard` de components o crear su propio diseño
- Comparte filtros similares a Home pero en formato lista

---

### ⚙️ DANIEL - CONFIGURACIÓN Y NOTIFICACIONES

#### ✅ PUEDE TOCAR:
```
✓ app/src/main/java/com/arequipaexplorer/ui/config/
  ├── ConfigScreen.kt
  ├── ConfigViewModel.kt
  └── components/
      ├── NotificationSettings.kt
      └── PreferenceItem.kt
```

#### ❌ NO PUEDE TOCAR:
```
✗ ui/theme/
✗ ui/components/ (compartidos)
✗ navigation/
✗ data/model/
```

#### 📝 RESPONSABILIDADES:
- Pantalla de configuración
- Toggle de "Notificaciones diarias" (ON/OFF)
- Sección "Notificaciones pendientes"
- Sección "General" (Idioma, Historial de actividades)
- Sección "Acerca de" (Créditos, Términos de servicio)
- Bottom navigation activo en "Config"

#### 🔗 DEPENDENCIAS:
- Guardar preferencias con `SharedPreferences` o `DataStore`
- Los switches deben funcionar y persistir

---

## ⚠️ ARCHIVOS COMPARTIDOS (Coordinación Requerida)

### 1. **data/model/** - Modelos de datos
**QUIÉN MODIFICA:** Cualquiera, pero AVISAR al grupo primero

```kotlin
// Lugar.kt
data class Lugar(
    val id: String,
    val nombre: String,
    val descripcion: String,
    val categoria: String,
    val precio: Double,
    val imagenUrl: String,
    val rating: Float,
    val isFavorito: Boolean = false
)
```

### 2. **ui/components/** - Componentes reutilizables
**QUIÉN CREA:** Quien lo necesite primero, AVISAR al crear nuevo

Componentes iniciales necesarios:
- `LugarCard.kt` - Card para mostrar lugares
- `BottomNavigationBar.kt` - Barra inferior
- `TopAppBar.kt` - Barra superior
- `SearchBar.kt` - Barra de búsqueda

### 3. **ui/theme/** - Colores y estilos
**QUIÉN MODIFICA:** SOLO LÍDER DEL PROYECTO

```kotlin
// Color.kt
val PrimaryColor = Color(0xFF6366F1)
val SecondaryColor = Color(0xFF8B5CF6)
```

### 4. **navigation/** - Sistema de navegación
**QUIÉN MODIFICA:** TODOS deben agregar su ruta, pero con cuidado

```kotlin
// Screen.kt
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Search : Screen("search")
    object Detalle : Screen("detalle/{lugarId}") {
        fun createRoute(lugarId: String) = "detalle/$lugarId"
    }
    object Favoritos : Screen("favoritos")
    object Lista : Screen("lista")
    object Config : Screen("config")
}
```

### 5. **data/repository/** - Repositorios
**QUIÉN CREA:** Según necesidad, AVISAR antes

---

## 🔄 FLUJO DE TRABAJO GIT

### SETUP INICIAL (Solo la primera vez)

```bash
# Clonar el proyecto
git clone [URL_DEL_REPO]
cd ArequipaExplorer

# Ver ramas disponibles
git branch -a
```

### CREAR TU RAMA

```bash
# Rodrigo
git checkout -b feature/home-rodrigo

# Sebastian
git checkout -b feature/detalle-sebastian

# Misael
git checkout -b feature/favoritos-misael

# Joe
git checkout -b feature/lista-joe

# Daniel
git checkout -b feature/config-daniel
```

### TRABAJAR EN TU RAMA

```bash
# Ver en qué rama estás
git branch

# Hacer cambios...
# Guardar cambios
git add .
git commit -m "feat(home): agregar pantalla principal"

# Subir a GitHub
git push origin feature/home-rodrigo
```

### SINCRONIZAR CON MAIN

```bash
# Antes de crear Pull Request
git checkout main
git pull origin main

git checkout feature/home-rodrigo
git merge main
# Resolver conflictos si hay

git push origin feature/home-rodrigo
```

### CREAR PULL REQUEST

1. Ir a GitHub
2. Click en "Pull Request"
3. Base: `main` ← Compare: `feature/home-rodrigo`
4. Título: "feat: Pantalla Home completa"
5. Descripción de cambios
6. Asignar revisor (otro dev)
7. Esperar aprobación
8. Merge

---

## 📦 DEPENDENCIAS (build.gradle.kts)

```kotlin
dependencies {
    // Core Android
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    
    // Compose
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    
    // Navigation
    implementation("androidx.navigation:navigation-compose:2.7.6")
    
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    
    // Coil - Cargar imágenes
    implementation("io.coil-kt:coil-compose:2.5.0")
    
    // Opcional: Room Database
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    
    // Opcional: DataStore para preferencias (Daniel)
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    
    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
}
```

---

## 📋 CHECKLIST ANTES DE HACER PR

### Para TODOS:

- [ ] Código compila sin errores
- [ ] No hay warnings importantes
- [ ] Probado en al menos un emulador/dispositivo
- [ ] Solo tocaste TU carpeta (o avisaste si tocaste compartido)
- [ ] Sincronizaste con `main` antes del PR
- [ ] Commit messages claros: `feat(home): descripción`
- [ ] Navegación funciona correctamente
- [ ] Bottom navigation se muestra

### Específico por Developer:

**Rodrigo (Home):**
- [ ] Búsqueda funciona
- [ ] Filtros cambian contenido
- [ ] Cards navegan a detalle
- [ ] Imagen del Cañón se muestra

**Sebastian (Detalle):**
- [ ] Recibe correctamente el ID del lugar
- [ ] Galería de imágenes funciona
- [ ] Botón favorito funciona
- [ ] Botón compartir funciona
- [ ] Precio se muestra correctamente

**Misael (Favoritos):**
- [ ] Lista se actualiza al agregar/quitar favoritos
- [ ] Muestra estado vacío
- [ ] Navega a detalle

**Joe (Lista):**
- [ ] Filtros funcionan
- [ ] Scroll fluido
- [ ] Botón favorito en cada card funciona
- [ ] Navega a detalle

**Daniel (Config):**
- [ ] Switches persisten al cerrar app
- [ ] Todas las opciones son clickeables
- [ ] Navegación a sub-pantallas funciona

---

## 🚨 REGLAS DE ORO

### ✅ HACER:
1. Trabajar SOLO en tu carpeta asignada
2. Commits pequeños y frecuentes
3. Avisar en el chat si necesitas tocar algo compartido
4. Probar tu código antes de subir
5. Hacer PR cuando tu pantalla esté funcional

### ❌ NO HACER:
1. Tocar archivos compartidos sin avisar
2. Hacer commits gigantes (1000+ líneas)
3. Subir código que no compile
4. Trabajar directo en `main`
5. Ignorar conflictos de Git

---

## 💬 COMUNICACIÓN

### Grupo de WhatsApp/Discord:
- Avisar cuando vayas a tocar algo compartido
- Avisar cuando hagas un PR
- Pedir ayuda si tienes conflictos de Git
- Coordinar reuniones si es necesario

### Ejemplo de mensaje:
> "🔔 Voy a agregar un nuevo componente `FilterChip.kt` en ui/components/ para los filtros. ¿Alguien lo necesita también?"

---

## 🆘 AYUDA COMÚN

### "¿Cómo navego a otra pantalla?"
```kotlin
navController.navigate("detalle/123")
navController.navigate(Screen.Favoritos.route)
```

### "¿Cómo obtengo datos del ViewModel?"
```kotlin
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val lugares = viewModel.lugares.value
    // Usar lugares...
}
```

### "Tengo conflictos en Git"
```bash
# Ver archivos en conflicto
git status

# Abrir archivo, buscar <<<<<<, resolver manualmente
# Guardar cambios
git add .
git commit -m "fix: resolver conflictos"
```

### "¿Cómo cargo imágenes?"
```kotlin
// Con Coil
AsyncImage(
    model = lugar.imagenUrl,
    contentDescription = lugar.nombre,
    modifier = Modifier.fillMaxWidth()
)
```

---

## 📞 CONTACTO DEL EQUIPO

- **Rodrigo** - Home - @rodrigo
- **Sebastian** - Detalle - @sebastian
- **Misael** - Favoritos - @misael
- **Joe** - Lista - @joe
- **Daniel** - Config - @daniel
- **Líder/Coordinador** - [Definir quién]

---

## 🎯 OBJETIVO FINAL

Cada uno entrega su pantalla funcional que:
1. ✅ Se ve como el diseño de Figma
2. ✅ Navega correctamente
3. ✅ Usa el ViewModel (MVVM)
4. ✅ Compila sin errores
5. ✅ Está integrada en la app completa

**¡Éxito en el proyecto! 🚀**