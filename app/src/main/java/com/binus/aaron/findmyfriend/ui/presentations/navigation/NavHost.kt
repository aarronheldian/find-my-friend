package com.binus.aaron.findmyfriend.ui.presentations.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.anggie.coffepedia.presentations.navigation.NavigationItem
import com.binus.aaron.findmyfriend.ui.presentations.detail.DetailScreen
import com.binus.aaron.findmyfriend.ui.presentations.home.HomeScreen
import com.binus.aaron.findmyfriend.ui.presentations.welcome.WelcomeScreen

@Composable
fun NavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            NavigationItem.Detail.route,
            arguments = listOf(navArgument("id") {
                type = NavType.StringType
            })
        ) {
            val id = it.arguments?.getString("id")
            if (id != null) {
                DetailScreen(navController = navController, id = id.toInt())
            }
        }
    }
}