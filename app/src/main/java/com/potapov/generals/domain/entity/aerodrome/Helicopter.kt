package com.potapov.generals.domain.entity.aerodrome

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Helicopter(
    val createTime: Int,
    val level: Int,
    val life: Int,
    val attack: Int,
) : Parcelable