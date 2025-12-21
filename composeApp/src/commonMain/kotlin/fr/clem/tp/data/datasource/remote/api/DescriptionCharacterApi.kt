package fr.clem.tp.data.datasource.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class DescriptionCharacterApi (private val client: HttpClient) {

    suspend fun getDescription(): HttpResponse =
        client.get("https://lorem-api.com/api/lorem")
}