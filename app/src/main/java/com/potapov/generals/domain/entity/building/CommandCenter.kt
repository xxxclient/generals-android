package com.potapov.generals.domain.entity.building

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommandCenter(
    val level: Int,
) : Parcelable