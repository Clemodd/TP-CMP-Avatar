package fr.clem.tp.app.create

import fr.clem.tp.navigation.Screen

sealed interface CreateIntent {
    data object Init : CreateIntent
    data class TitleChanged(val value: String) : CreateIntent
    data class DescriptionChanged(val value: String) : CreateIntent
    data class ImageSelected(val image: UiImage) : CreateIntent
    data object Validate : CreateIntent
    data object Back : CreateIntent
}

sealed interface CreateEffect {
    data object PopBack : CreateEffect
    data class NavigateTo(val screen: Screen) : CreateEffect
}