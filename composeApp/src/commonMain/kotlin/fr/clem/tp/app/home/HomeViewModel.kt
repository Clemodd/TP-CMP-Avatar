package fr.clem.tp.app.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.clem.tp.data.mapper.toHomeItemUi
import fr.clem.tp.domain.usecase.CharacterUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {

    val state: StateFlow<HomeState>
        field = MutableStateFlow(HomeState())

    private val _effect = Channel<HomeEffect>()
    val effect = _effect.receiveAsFlow()

    fun onIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.Init -> {
                viewModelScope.launch {
                    state.value = state.value.copy(
                        items = characterUseCase.getAll()
                            .map { it.toHomeItemUi() }
                    )
                }
            }

            is HomeIntent.GoToDetails -> {
                viewModelScope.launch {
                    _effect.send(
                        HomeEffect.NavigateToDetails(
                            id = intent.id
                        )
                    )
                }
            }
            HomeIntent.CreateElement -> {
                viewModelScope.launch {
                    _effect.send(
                        HomeEffect.NavigateToCreate
                    )
                }
            }
            HomeIntent.GoToFavorites -> {
                viewModelScope.launch {
                    _effect.send(
                        HomeEffect.NavigateToFavorites
                    )
                }
            }
        }
    }
}