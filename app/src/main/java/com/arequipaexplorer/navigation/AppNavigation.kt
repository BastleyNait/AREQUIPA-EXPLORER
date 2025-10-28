package com.arequipaexplorer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arequipaexplorer.ui.config.ConfigScreen
import com.arequipaexplorer.ui.detalle.PlaceDetailScreen
import com.arequipaexplorer.ui.favoritos.FavoritesScreen
import com.arequipaexplorer.ui.home.HomeScreen
import com.arequipaexplorer.ui.lista.PlaceListScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToPlaceDetail = { placeId ->
                    navController.navigate(Screen.PlaceDetail.createRoute(placeId))
                },
                onNavigateToPlacesList = {
                    navController.navigate(Screen.PlaceList.route)
                }
            )
        }
        
        composable(Screen.PlaceList.route) {
            PlaceListScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToPlaceDetail = { placeId ->
                    navController.navigate(Screen.PlaceDetail.createRoute(placeId))
                }
            )
        }
        
        composable(
            route = Screen.PlaceDetail.route,
            arguments = Screen.PlaceDetail.arguments
        ) { backStackEntry ->
            val placeId = backStackEntry.arguments?.getInt("placeId") ?: 0
            PlaceDetailScreen(
                placeId = placeId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Favorites.route) {
            FavoritesScreen(
                onNavigateToPlaceDetail = { placeId ->
                    navController.navigate(Screen.PlaceDetail.createRoute(placeId))
                }
            )
        }
        
        composable(Screen.Config.route) {
            ConfigScreen()
        }
    }
}