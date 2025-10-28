package com.arequipaexplorer.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    object Home : Screen("home")
    
    object PlaceList : Screen("place_list")
    
    object PlaceDetail : Screen(
        route = "place_detail/{placeId}",
        arguments = listOf(
            navArgument("placeId") {
                type = NavType.IntType
            }
        )
    ) {
        fun createRoute(placeId: Int) = "place_detail/$placeId"
    }
    
    object Favorites : Screen("favorites")
    
    object Config : Screen("config")
}