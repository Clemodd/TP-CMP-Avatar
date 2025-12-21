package fr.clem.tp.data.network

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

suspend inline fun <reified T : Any> traiterRetour(response: HttpResponse): Result<T> = try {
    if (response.status == HttpStatusCode.OK) {
        Result.success(response.body())
    } else {
        Result.failure(Exception("Erreur HTTP ${response.status}"))
    }
} catch (e: Exception) {
    Result.failure(e)
}