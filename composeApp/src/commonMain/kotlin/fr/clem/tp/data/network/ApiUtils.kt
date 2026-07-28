package fr.clem.tp.data.network

import io.ktor.client.statement.HttpResponse

// TODO TP2
suspend inline fun <reified T : Any> traiterRetour(response: HttpResponse): Result<T> {
    TODO("Si OK, Success sinon Failure avec un message d'erreur")
}

