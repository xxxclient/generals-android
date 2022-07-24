package com.potapov.generals.data.db_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "units")
data class UnitDbModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val race: String,
    val level: Int
)