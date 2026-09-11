package fr.clem.tp.data.datasource.local

import fr.clem.tp.MyDatabase
import fr.clem.tp.data.mapper.toDb
import fr.clem.tp.data.mapper.toDomain
import fr.clem.tp.domain.model.Character

class CharacterLocalDataSource(
    private val database: MyDatabase
) {
    private val queries = database.characterQueries

    fun insert(character: Character) {
        val (type, path) = requireNotNull(character.image) {
            "Cannot insert a character without an image"
        }.toDb()

        queries.insertCharacter(
            id = character.id,
            title = character.title,
            description = character.description,
            imageType = type,
            imagePath = path
        )
    }

    fun getAll(): List<Character> =
        queries.selectAll()
            .executeAsList()
            .map { it.toDomain() }

    fun getById(id: String): Character {
        val result = queries.selectById(id).executeAsOneOrNull()
            ?: error("Character with id=$id not found in local database")

        return result.toDomain()
    }

    fun updateFavorite(id: String, isFavorite: Boolean) {
        queries.updateFavorite(
            isFavorite = if (isFavorite) 1 else 0,
            id = id
        )
    }

    fun delete(id: String) {
        queries.deleteById(id)
    }

    fun getFavorites(): List<Character> =
        queries.selectFavorites()
            .executeAsList()
            .map { it.toDomain() }
}
