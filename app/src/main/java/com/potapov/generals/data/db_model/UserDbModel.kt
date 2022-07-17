package com.potapov.generals.data.db_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDbModel(
    @PrimaryKey(autoGenerate = true) val userId: Int,
    val name: String
)