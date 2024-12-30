package br.com.carolis.alugames.services

import com.google.gson.Gson
import br.com.carolis.alugames.models.GameInfo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest.newBuilder
import java.net.http.HttpResponse.BodyHandlers

class APIService {

    fun findGameById(id: String): GameInfo? {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = newBuilder()
            .uri(URI.create(url))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        val jsonResponse = response.body()

        val gson = Gson()
        return runCatching { gson.fromJson(jsonResponse, GameInfo::class.java) }

            .onFailure {
                throw IllegalArgumentException("$id é inválido. Tente outro número.")
            }
            .getOrThrow()

    }
}