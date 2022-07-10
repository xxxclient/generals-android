package com.potapov.generals.domain.entity.building

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shipyard(
    val level: Int,
    val boatCount: Int,
    val frigateCount: Int,
    val submarineCount: Int,
) : Parcelable