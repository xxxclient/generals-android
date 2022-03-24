package com.potapov.generals.domain.entity.building

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Factory(
    val level: Int,
    val apcCount: Int,
    val armoredCount: Int,
    val tankCount: Int,
) : Parcelable