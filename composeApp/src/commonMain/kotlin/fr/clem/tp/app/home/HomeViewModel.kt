package fr.clem.tp.app.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        // TODO TP3
    }

    private fun sendEffect(effect: HomeEffect) {
        viewModelScope.launch { _effect.send(effect) }
    }
}