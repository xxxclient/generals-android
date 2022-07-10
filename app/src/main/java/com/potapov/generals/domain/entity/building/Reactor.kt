package com.potapov.generals.domain.entity.building

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Reactor(
    val level: Int,
) : Parcelable