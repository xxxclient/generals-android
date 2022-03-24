package com.potapov.generals.domain.entity

import android.os.Parcelable
import com.potapov.generals.domain.entity.building.Aerodrome
import com.potapov.generals.domain.entity.building.Barracks
import com.potapov.generals.domain.entity.building.Factory
import com.potapov.generals.domain.entity.building.Headquarters
import com.potapov.generals.domain.entity.building.Laboratory
import com.potapov.generals.domain.entity.building.OilDerrick
import kotlinx.parcelize.Parcelize

@Parcelize
data class Statistic(
    val aerodrome: Aerodrome,
    val barracks: Barracks,
    val factory: Factory,
    val headquarters: Headquarters,
    val laboratory: Laboratory,
    val oilDerrick: OilDerrick,
    val army: Army,
    val resources: Resources,
) : Parcelable {

    companion object {

        val DEFAULT = Statistic(
            Aerodrome(0, 0, 0),
            Barracks(0, 0, 0, 0),
            Factory(0, 0, 0, 0),
            Headquarters(0),
            Laboratory(0),
            OilDerrick(0),
            Army.RUSSIA,
            Resources(0, 0)
        )
    }
}