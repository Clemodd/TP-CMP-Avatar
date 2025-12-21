package fr.clem.tp.app.detail

sealed interface DetailIntent {
    data class Init(val id: String) : DetailIntent
    data object GoBackToHome : DetailIntent
    data object ToggleFavorite : DetailIntent
}

sealed interface DetailEffect {
    data object NavigateToHome : DetailEffect
}
