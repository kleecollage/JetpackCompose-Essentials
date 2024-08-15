package com.example.notificationproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notificationproject.views.AboutView
import com.example.notificationproject.views.AccountView
import com.example.notificationproject.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home" ) {
        composable("Home") { HomeView(navController) }
        composable("About") { AboutView() }
        composable("Account") { AccountView() }
    }
}