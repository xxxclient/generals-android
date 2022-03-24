package com.potapov.generals.domain.entity.barracks

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shooter(
    val createTime: Int,
    val level: Int,
    val life: Int,
    val attack: Int,
) : Parcelable