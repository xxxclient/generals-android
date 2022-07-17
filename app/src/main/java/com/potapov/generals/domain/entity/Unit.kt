package com.potapov.generals.domain.entity

data class Unit(
    var userId: Int = UNDEFINED_ID,
    val name: String
) {

    companion object {

        const val UNDEFINED_ID = 0
    }
}
