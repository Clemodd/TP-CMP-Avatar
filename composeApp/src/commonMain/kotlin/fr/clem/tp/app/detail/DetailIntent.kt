package fr.clem.tp.app.detail

import fr.clem.tp.app.create.CreateEffect
import fr.clem.tp.navigation.Screen

sealed interface DetailIntent {
    data class Init(val id: String) : DetailIntent
    data object GoBackToHome : DetailIntent
    data object ToggleFavorite : DetailIntent
}

sealed interface DetailEffect {
    data object PopBack : DetailEffect
}
