package fr.clem.tp.app.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.clem.tp.app.create.CreateEffect
import fr.clem.tp.data.mapper.toFavoriteItemUi
import fr.clem.tp.domain.usecase.FavoriteUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val favoriteUseCase: FavoriteUseCase
) : ViewModel() {

    val state: StateFlow<FavoriteState>
        field = MutableStateFlow(FavoriteState())

    private val _effect = Channel<FavoriteEffect>()
    val effect = _effect.receiveAsFlow()

    fun onIntent(intent: FavoriteIntent) {
        when (intent) {
            FavoriteIntent.Init -> {
                viewModelScope.launch {
                    state.value = state.value.copy(
                        items = favoriteUseCase.getAllFavorites()
                            .map { it.toFavoriteItemUi() }
                    )
                }
            }

            FavoriteIntent.Retour -> {
                sendEffect(FavoriteEffect.PopBack)
            }

            is FavoriteIntent.ToggleFavorite -> {
                viewModelScope.launch {
                    favoriteUseCase.updateFavorite(intent.id, intent.isFavorite)

                    state.value = state.value.copy(
                        items = favoriteUseCase.getAllFavorites()
                            .map { it.toFavoriteItemUi() }
                    )
                }
            }
        }
    }

    private fun sendEffect(effect: FavoriteEffect) {
        viewModelScope.launch { _effect.send(effect) }
    }
}