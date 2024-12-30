package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest.newBuilder
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    println("Digite o código do jogo para buscar:")
    val search = scan.nextLine()
    val url = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = newBuilder()
        .uri(URI.create(url))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val jsonResponse = response.body()

    val gson = Gson()
    val myInfoGame = gson.fromJson(jsonResponse, GameInfo::class.java)

    val result = runCatching {
        val myGame = Game(myInfoGame.info.title, myInfoGame.info.thumb)
        println(myGame)
    }

    result.onFailure {
        println("Jogo inexistente. Tente outro id")
    }

}