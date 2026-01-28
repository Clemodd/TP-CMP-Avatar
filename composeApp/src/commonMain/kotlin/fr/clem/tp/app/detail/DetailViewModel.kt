package fr.clem.tp.app.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.clem.tp.domain.usecase.CharacterUseCase
import fr.clem.tp.domain.usecase.FavoriteUseCase
import fr.clem.tp.navigation.Screen
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(
    private val characterUseCase: CharacterUseCase,
    private val favoriteUseCase: FavoriteUseCase
) : ViewModel() {

    val state: StateFlow<DetailState>
        field = MutableStateFlow(DetailState())

    private val _effect = Channel<DetailEffect>()
    val effect = _effect.receiveAsFlow()

    fun onIntent(intent: DetailIntent) {
        when (intent) {
            is DetailIntent.Init -> loadCharacter(intent.id)
            DetailIntent.GoBackToHome -> sendEffect(DetailEffect.PopBack)
            DetailIntent.ToggleFavorite -> toggleFavorite()
        }
    }

    private fun toggleFavorite() {
        viewModelScope.launch {
            val newValue = !state.value.isFavorite

            favoriteUseCase.updateFavorite(
                id = state.value.id,
                isFavorite = newValue
            )

            state.value = state.value.copy(
                isFavorite = newValue
            )
        }
    }


    private fun loadCharacter(id: String) {
        viewModelScope.launch {
            val character = characterUseCase.getById(id)
            state.update {
                it.copy(
                    id = character.id,
                    title = character.title,
                    description = character.description,
                    image = character.image,
                    isFavorite = character.isFavorite,
                )
            }
        }
    }

    private fun sendEffect(effect: DetailEffect) {
        viewModelScope.launch { _effect.send(effect) }
    }
}