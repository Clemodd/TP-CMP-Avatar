package fr.clem.tp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()

    @Serializable
    data class Details(val id: String)

    @Serializable
    data object Favorites : Screen()

    @Serializable
    data object Create : Screen()
}