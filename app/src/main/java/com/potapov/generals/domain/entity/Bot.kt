package com.potapov.generals.domain.entity

data class Bot(
    var id: Int = BOT_ID,
    val race: String,
    val level: Int
) {

    companion object {

        const val UNDEFINED_ID = 0
        const val BOT_ID = 1
    }
}
