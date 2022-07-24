package com.potapov.generals.domain.entity.airbase

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fighter(
    val creationTime: Int,
    val level: Int,
    val life: Int,
    val attack: Int,
) : Parcelable