package fr.clem.tp.data.datasource.remote

import fr.clem.tp.data.datasource.remote.api.DescriptionCharacterApi

class DescriptionRemoteDataSource(
    private val api: DescriptionCharacterApi
) {
    suspend fun getDescription(): Result<String> {
        TODO("TP2.2 : appeler l'api")
    }
}

