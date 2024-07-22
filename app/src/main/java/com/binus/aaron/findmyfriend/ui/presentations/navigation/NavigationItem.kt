package com.anggie.coffepedia.presentations.navigation

enum class AppScreen {
    WELCOME,
    HOME,
}

sealed class NavigationItem(val route: String) {
    object Welcome: NavigationItem(AppScreen.WELCOME.name)
    object Home: NavigationItem(AppScreen.HOME.name)
    object Detail: NavigationItem("detail/{id}") {
        fun createRoute(id: Int): String = "detail/$id"
    }
}