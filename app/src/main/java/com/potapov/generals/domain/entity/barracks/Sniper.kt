package com.potapov.generals.domain.entity.barracks

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sniper(
    val creationTime: Int,
    val level: Int,
    val life: Int,
    val attack: Int,
) : Parcelable