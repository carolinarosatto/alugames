package org.example

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest.newBuilder
import java.net.http.HttpResponse.BodyHandlers


fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=612"))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val jsonResponse = response.body()

    val myGame = Game("Minecraft", "oaihrsoiraoisnr")

    println(myGame)
}