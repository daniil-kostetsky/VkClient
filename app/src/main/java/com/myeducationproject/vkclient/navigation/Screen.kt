package com.myeducationproject.vkclient.navigation

sealed class Screen(
    val route: String
) {

    object Home : Screen(ROUTE_HOME)
    object Favourite : Screen(ROUTE_FAVOURITE)
    object Profile : Screen(ROUTE_PROFILE)

    private companion object {

        const val ROUTE_HOME = "home"
        const val ROUTE_FAVOURITE = "favourite"
        const val ROUTE_PROFILE = "profile"
    }
}
