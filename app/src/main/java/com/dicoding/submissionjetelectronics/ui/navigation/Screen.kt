package com.dicoding.submissionjetelectronics.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
    object DetailElectronics : Screen("home/{electronicsId}") {
        fun createRoute(electronicsId: Long) = "home/$electronicsId"
    }
    object description : Screen("detail")
}