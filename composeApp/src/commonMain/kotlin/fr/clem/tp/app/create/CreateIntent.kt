package fr.clem.tp.app.create

sealed interface CreateIntent {
    data object Init : CreateIntent
    data class TitleChanged(val value: String) : CreateIntent
    data class DescriptionChanged(val value: String) : CreateIntent
    data class ImageSelected(val image: UiImage) : CreateIntent
    data object Validate : CreateIntent
    data object Back : CreateIntent
}

sealed interface CreateEffect {
    data object NavigateToHome : CreateEffect
}