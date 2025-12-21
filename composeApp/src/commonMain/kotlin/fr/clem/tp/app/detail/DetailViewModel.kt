package fr.clem.tp.app.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.clem.tp.domain.usecase.CharacterUseCase
import fr.clem.tp.domain.usecase.FavoriteUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
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
            is DetailIntent.Init -> {
                viewModelScope.launch {
                    val character = characterUseCase.getById(intent.id)

                    state.value = state.value.copy(
                        id = character.id,
                        title = character.title,
                        description = character.description,
                        image = character.image,
                        isFavorite = character.isFavorite
                    )
                }
            }

            DetailIntent.GoBackToHome -> {
                viewModelScope.launch {
                    _effect.send(DetailEffect.NavigateToHome)
                }
            }

            is DetailIntent.ToggleFavorite -> {
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
        }
    }
}