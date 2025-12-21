package fr.clem.tp.data.datasource.local

import fr.clem.tp.MyDatabase
import fr.clem.tp.data.mapper.toDb
import fr.clem.tp.data.mapper.toUiImage
import fr.clem.tp.domain.model.Character

class CharacterLocalDataSource(
    private val database: MyDatabase
) {
    private val queries = database.characterQueries

    fun insert(character: Character) {
        val (type, path) = character.image!!.toDb()

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
            .map {
                Character(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                    image = it.toUiImage(),
                    isFavorite = it.isFavorite == 1L
                )
            }

    fun getById(id: String): Character {
        val result = queries.selectById(id).executeAsOneOrNull()
            ?: error("Character with id=$id not found in local database")


        return Character(
            id = result.id,
            title = result.title,
            description = result.description,
            image = result.toUiImage(),
            isFavorite = result.isFavorite == 1L
        )
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
            .map {
                Character(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                    image = it.toUiImage(),
                    isFavorite = true
                )
            }
}
