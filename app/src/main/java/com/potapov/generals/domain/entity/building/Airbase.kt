package com.potapov.generals.domain.entity.building

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Airbase(
    val level: Int,
    val fighterCount: Int,
    val helicopterCount: Int,
) : Parcelable