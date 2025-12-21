package fr.clem.tp.app.favorite

sealed interface FavoriteIntent {
    data object Init : FavoriteIntent
    data object Retour : FavoriteIntent
    data class ToggleFavorite(val id: String, val isFavorite: Boolean) : FavoriteIntent
}

sealed interface FavoriteEffect {
    data object NavigateToHome : FavoriteEffect
}