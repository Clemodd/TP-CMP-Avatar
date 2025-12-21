package fr.clem.tp.data.repository

import fr.clem.tp.data.datasource.local.CharacterLocalDataSource
import fr.clem.tp.data.datasource.remote.DescriptionRemoteDataSource
import fr.clem.tp.domain.model.Character
import fr.clem.tp.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val localDataSource: CharacterLocalDataSource,
    private val descriptionRemoteDataSource: DescriptionRemoteDataSource
) : CharacterRepository {

    override suspend fun create(character: Character) =
        localDataSource.insert(character)

    override suspend fun getAll(): List<Character> =
        localDataSource.getAll()

    override fun getFavorites(): List<Character> = localDataSource.getFavorites()

    override suspend fun getDescription(): Result<String> = descriptionRemoteDataSource.getDescription()

    override suspend fun getById(id: String): Character = localDataSource.getById(id)

    override fun updateFavorite(id: String, isFavorite: Boolean) {
        localDataSource.updateFavorite(id, isFavorite)
    }

    override fun delete(id: String) {
        localDataSource.delete(id)
    }
}
