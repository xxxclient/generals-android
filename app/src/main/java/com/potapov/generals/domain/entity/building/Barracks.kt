package com.potapov.generals.domain.entity.building

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Barracks(
    val level: Int,
    val grenadeLauncherCount: Int,
    val shooterCount: Int,
    val sniperCount: Int,
) : Parcelable