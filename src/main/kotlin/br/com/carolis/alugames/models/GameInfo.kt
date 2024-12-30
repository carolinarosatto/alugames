package br.com.carolis.alugames.models

data class GameInfo(val info: InfoApiCheapShark) {
    override fun toString(): String {
        return info.toString()
    }
}