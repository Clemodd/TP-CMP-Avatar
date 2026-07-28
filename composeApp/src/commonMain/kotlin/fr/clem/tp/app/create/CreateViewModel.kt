package fr.clem.tp.app.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.clem.tp.domain.usecase.CharacterUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CreateViewModel(
    private val characterUseCase: CharacterUseCase
) : ViewModel() {

    val state: StateFlow<CreateState>
        field = MutableStateFlow(CreateState())

    private val _effect = Channel<CreateEffect>()
    val effect = _effect.receiveAsFlow()

    fun onIntent(intent: CreateIntent) {
        // TODO TP3
    }

    private fun sendEffect(effect: CreateEffect) {
        viewModelScope.launch { _effect.send(effect) }
    }
}