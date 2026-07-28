package fr.clem.tp.data.datasource.remote

import fr.clem.tp.data.datasource.remote.api.DescriptionCharacterApi

class DescriptionRemoteDataSource(
    private val api: DescriptionCharacterApi
) {
    // TODO TP2
    suspend fun getDescription(): Result<String> {
        TODO()
    }
}

