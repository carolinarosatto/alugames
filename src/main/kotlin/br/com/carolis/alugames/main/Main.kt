package br.com.carolis.alugames.main

import br.com.carolis.alugames.services.APIService
import br.com.carolis.alugames.models.Game
import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    println("Digite o código do jogo para buscar:")
    val search = scan.nextLine()

    val searchApi = APIService()
    val infoGame = searchApi.findGameById(search)

    var myGame: Game? = null

    val result = runCatching {
        myGame = infoGame?.info?.let { Game(it.title, infoGame.info.thumb) }
    }

    result.onFailure {
        println("Jogo inexistente. Tente outro id")
    }

    result.onSuccess {
        println("Deseja incluir uma descrição personalizada? S/N")
        val option = scan.nextLine()
        if (option.equals("s", true)) {
            println("Insira a descrição personalizada:")
            val description = scan.nextLine()
            myGame?.description = description
        } else {
            myGame?.description = myGame?.title
        }
    }
    println(myGame)
    result.onSuccess {
        println("Pesquisa finalizada!")
    }
}