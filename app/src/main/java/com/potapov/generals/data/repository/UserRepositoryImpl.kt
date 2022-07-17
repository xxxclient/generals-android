package com.potapov.generals.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.potapov.generals.data.database.AppDatabase
import com.potapov.generals.data.mapper.UserMapper
import com.potapov.generals.domain.entity.User
import com.potapov.generals.domain.repository.UserRepository

class UserRepositoryImpl(application: Application) : UserRepository {

    private val userDao = AppDatabase.getInstance(application).userDao()
    private val mapper = UserMapper()

    override suspend fun addUser(user: User) {
        userDao.addUser(mapper.mapEntityToDbModel(user))
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user.userId)
    }

    override suspend fun editUser(user: User) {
        userDao.addUser(mapper.mapEntityToDbModel(user))
    }

    override suspend fun getUser(userId: Int): User {
        val dbModel = userDao.getUser(userId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getUserList(): LiveData<List<User>> = Transformations.map(
        userDao.getUserList()
    ) { mapper.mapListDbModelToListEntity(it) }
}