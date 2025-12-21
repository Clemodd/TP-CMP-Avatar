package fr.clem.tp.domain.repository

import fr.clem.tp.domain.model.Character

interface CharacterRepository {
    suspend fun create(character: Character)
    suspend fun getAll(): List<Character>
    fun getFavorites(): List<Character>
    suspend fun getDescription(): Result<String>
    suspend fun getById(id: String): Character
    fun updateFavorite(id: String, isFavorite: Boolean)
    fun delete(id: String)
}
