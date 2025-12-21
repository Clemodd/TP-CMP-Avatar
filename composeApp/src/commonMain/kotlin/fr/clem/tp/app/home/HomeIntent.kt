package fr.clem.tp.app.home

sealed interface HomeIntent {
    data object Init : HomeIntent
    data class GoToDetails(val id: String) : HomeIntent
    data object CreateElement : HomeIntent
    data object GoToFavorites : HomeIntent
}

sealed interface HomeEffect {
    data class NavigateToDetails(val id: String) : HomeEffect
    data object NavigateToCreate : HomeEffect
    data object NavigateToFavorites : HomeEffect
}