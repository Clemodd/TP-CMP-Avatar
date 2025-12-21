package fr.clem.tp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object Home

    @Serializable
    data class Details(val id: String)

    @Serializable
    object Favorites

    @Serializable
    object Create
}