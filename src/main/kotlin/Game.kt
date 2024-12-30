package org.example

class Game(
    val title: String,
    val thumbnail: String
) {
    val description = ""

    override fun toString(): String {
        return "Game(title='$title', thumbnail='$thumbnail', description='$description')"
    }
}