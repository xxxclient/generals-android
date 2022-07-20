package com.potapov.generals.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.potapov.generals.data.dao.UserDao
import com.potapov.generals.data.db_model.UserDbModel

@Database(
    entities = [UserDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private const val DB_NAME = "database.db"

        fun getInstance(context: Context): AppDatabase =
                Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
    }
}