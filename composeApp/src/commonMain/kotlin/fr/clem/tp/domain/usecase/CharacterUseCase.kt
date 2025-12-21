package fr.clem.tp.domain.usecase

import fr.clem.tp.domain.model.Character
import fr.clem.tp.domain.repository.CharacterRepository
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class CharacterUseCase(
    private val repository: CharacterRepository
) {
    @OptIn(ExperimentalUuidApi::class)
    suspend fun create(character: Character) {
        repository.create(
            Character(
                id = Uuid.random().toString(),
                title = character.title,
                description = character.description,
                image = character.image,
                isFavorite = character.isFavorite
            )
        )
    }

    suspend fun getAll() = repository.getAll()

    suspend fun getById(id: String) = repository.getById(id)

    suspend fun deleteById(id: String) = repository.delete(id)

    suspend fun getDescription() = repository.getDescription()
}