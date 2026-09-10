package fr.clem.tp.data.network

import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T : Any> traiterRetour(response: HttpResponse): Result<T> {
    TODO("TP2.2 : Success si 200 OK, sinon Failure avec un message d'erreur")
}

