package com.example.mapas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mapas.viewModel.SearchViewModel
import com.example.mapas.views.HomeVew
import com.example.mapas.views.MapSearchView
import kotlin.reflect.typeOf

@Composable
fun NavManager(searchVM: SearchViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home" ) {
        composable("Home") { HomeVew(navController, searchVM) }
        composable(
            "MapSearchView/{lat}/{lng}/{address}",
            arguments = listOf(
                navArgument("lat") { type = NavType.FloatType },
                navArgument("lng") { type = NavType.FloatType },
                navArgument("address") { type = NavType.StringType },
            )) {
            val lat = it.arguments?.getFloat("lat") ?: 0.0
            val lng = it.arguments?.getFloat("lng") ?: 0.0
            val address = it.arguments?.getString("address") ?: ""
            MapSearchView(lat.toDouble(), lng.toDouble(), address)
        }
    }
}