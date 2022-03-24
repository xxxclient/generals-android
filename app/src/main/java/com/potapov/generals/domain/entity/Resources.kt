package com.potapov.generals.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resources(
    val money: Int,
    val energy: Int,
) : Parcelable