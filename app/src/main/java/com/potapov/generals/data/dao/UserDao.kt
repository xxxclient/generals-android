package com.potapov.generals.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.potapov.generals.data.db_model.UserDbModel

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUserList(): LiveData<List<UserDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(shopItemDbModel: UserDbModel)

    @Query("DELETE FROM users WHERE userId=:userId")
    suspend fun deleteUser(userId: Int)

    @Query("SELECT * FROM users WHERE userId=:userId LIMIT 1")
    suspend fun getUser(userId: Int): UserDbModel
}