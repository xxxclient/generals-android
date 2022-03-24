package com.potapov.generals.domain.entity.building

import com.potapov.generals.domain.entity.factory.Apc
import com.potapov.generals.domain.entity.factory.ArmoredCar
import com.potapov.generals.domain.entity.factory.Tank

data class Factory(
    val level: Int,
    val life: Int,
    val apcCount: Int,
    val armoredCount: Int,
    val tankCount: Int,
)