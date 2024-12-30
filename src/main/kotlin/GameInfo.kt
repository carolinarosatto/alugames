package org.example

data class GameInfo(val info: InfoApiCheapShark) {
    override fun toString(): String {
        return info.toString()
    }
}