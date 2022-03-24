package com.potapov.generals.domain.entity

import com.potapov.generals.domain.entity.building.Aerodrome
import com.potapov.generals.domain.entity.building.Barracks
import com.potapov.generals.domain.entity.building.Factory
import com.potapov.generals.domain.entity.building.Headquarters
import com.potapov.generals.domain.entity.building.Laboratory
import com.potapov.generals.domain.entity.building.OilDerrick

data class Statistic(
    val aerodrome: Aerodrome,
    val barracks: Barracks,
    val factory: Factory,
    val headquarters: Headquarters,
    val laboratory: Laboratory,
    val oilDerrick: OilDerrick,
    val army: Army,
    val resources: Resources,
)