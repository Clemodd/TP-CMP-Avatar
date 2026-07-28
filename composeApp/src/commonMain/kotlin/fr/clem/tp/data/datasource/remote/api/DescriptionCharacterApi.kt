package fr.clem.tp.data.datasource.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse

class DescriptionCharacterApi(private val client: HttpClient) {

    // TODO TP2
    suspend fun getDescription(): HttpResponse {
        TODO()
    }
}

