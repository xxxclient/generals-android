package com.potapov.generals.domain.entity.factory

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Howitzer(
    val creationTime: Int,
    val level: Int,
    val life: Int,
    val attack: Int,
) : Parcelable