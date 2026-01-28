package fr.clem.tp.app.favorite

import fr.clem.tp.app.create.CreateEffect
import fr.clem.tp.navigation.Screen

sealed interface FavoriteIntent {
    data object Init : FavoriteIntent
    data object Retour : FavoriteIntent
    data class ToggleFavorite(val id: String, val isFavorite: Boolean) : FavoriteIntent
}

sealed interface FavoriteEffect {
    data object PopBack : FavoriteEffect
}