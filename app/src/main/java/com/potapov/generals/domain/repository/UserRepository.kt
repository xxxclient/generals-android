package com.potapov.generals.domain.repository

import androidx.lifecycle.LiveData
import com.potapov.generals.domain.entity.User

interface UserRepository {

    suspend fun addUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun editUser(user: User)
    suspend fun getUser(userId: Int): User
    fun getUserList(): LiveData<List<User>>
}