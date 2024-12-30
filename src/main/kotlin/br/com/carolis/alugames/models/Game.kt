package br.com.carolis.alugames.models

class Game(
    val title: String,
    val thumbnail: String
) {
    var description: String? = null

    override fun toString(): String {
        return "Game\n" +
                "title='$title' \n" +
                "thumbnail='$thumbnail'\n" +
                "description='$description'"
    }
}