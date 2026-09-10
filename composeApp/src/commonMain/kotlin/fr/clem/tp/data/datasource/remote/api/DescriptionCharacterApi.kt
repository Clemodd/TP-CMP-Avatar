package fr.clem.tp.data.datasource.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse

class DescriptionCharacterApi(private val client: HttpClient) {

    suspend fun getDescription(): HttpResponse {
        TODO("TP2.2 : appel GET vers https://lorem-api.com/api/lorem")
    }
}

