package fr.clem.tp.app.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.clem.tp.data.mapper.toDomain
import fr.clem.tp.domain.usecase.CharacterUseCase
import fr.clem.tp.navigation.Screen
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
        when (intent) {

            CreateIntent.Init -> {
                viewModelScope.launch {
                    characterUseCase.getDescription()
                        .onSuccess {
                            onIntent(CreateIntent.DescriptionChanged(it))
                        }
                }
            }

            is CreateIntent.TitleChanged -> {
                checkValidity(state.value.copy(title = intent.value))
            }

            is CreateIntent.DescriptionChanged -> {
                checkValidity(state.value.copy(description = intent.value))
            }

            is CreateIntent.ImageSelected -> {
                checkValidity(state.value.copy(image = intent.image))
            }

            CreateIntent.Validate -> {
                if (!state.value.isValid) return

                viewModelScope.launch {
                    characterUseCase.create(state.value.toDomain())
                    sendEffect(CreateEffect.NavigateTo(Screen.Home))

                    state.value = CreateState()
                }
            }

            CreateIntent.Back -> {
                sendEffect(CreateEffect.PopBack)
            }
        }
    }

    private fun checkValidity(newState: CreateState) {
        state.value = newState.copy(
            isValid =
                newState.title.isNotBlank() &&
                        newState.description.isNotBlank() &&
                        newState.image != null
        )
    }

    private fun sendEffect(effect: CreateEffect) {
        viewModelScope.launch { _effect.send(effect) }
    }
}