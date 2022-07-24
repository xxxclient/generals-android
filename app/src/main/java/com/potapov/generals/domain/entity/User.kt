package com.potapov.generals.domain.entity

data class User(
    var id: Int = USER_ID,
    val race: String
) {

    companion object {

        const val UNDEFINED_ID = 0
        const val USER_ID = 1
    }
}
