package com.potapov.generals.domain.entity.building

import com.potapov.generals.domain.entity.barracks.GrenadeLauncher
import com.potapov.generals.domain.entity.barracks.Shooter
import com.potapov.generals.domain.entity.barracks.Sniper

data class Barracks(
    val level: Int,
    val life: Int,
    val grenadeLauncherCount: Int,
    val shooterCount: Int,
    val sniperCount: Int,
)