package com.potapov.generals.domain.usecase

import androidx.lifecycle.LiveData
import com.potapov.generals.domain.entity.User
import com.potapov.generals.domain.repository.UserRepository

class UserUseCase(
    private val userRepository: UserRepository
) {

    suspend fun addUser(user: User) {
        userRepository.addUser(user)
    }

    suspend fun deleteUser(user: User) {
        userRepository.deleteUser(user)
    }

    suspend fun editUser(user: User) {
        userRepository.editUser(user)
    }

    suspend fun getUser(userId: Int): User {
        return userRepository.getUser(userId)
    }

    fun getUserList(): LiveData<List<User>> {
        return userRepository.getUserList()
    }
}