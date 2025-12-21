package fr.clem.tp.data.datasource.remote

import fr.clem.tp.data.datasource.remote.api.DescriptionCharacterApi
import fr.clem.tp.data.network.traiterRetour

class DescriptionRemoteDataSource(
    private val api: DescriptionCharacterApi
) {
    suspend fun getDescription(): Result<String> = traiterRetour(api.getDescription())
}