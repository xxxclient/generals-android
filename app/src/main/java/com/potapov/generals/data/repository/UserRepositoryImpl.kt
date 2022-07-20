package com.potapov.generals.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.potapov.generals.data.dao.UserDao
import com.potapov.generals.data.mapper.UserMapper
import com.potapov.generals.domain.entity.User
import com.potapov.generals.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userMapper: UserMapper
) : UserRepository {

    override suspend fun addUser(user: User) {
        userDao.addUser(userMapper.mapEntityToDbModel(user))
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user.userId)
    }

    override suspend fun editUser(user: User) {
        userDao.addUser(userMapper.mapEntityToDbModel(user))
    }

    override suspend fun getUser(userId: Int): User {
        val dbModel = userDao.getUser(userId)
        return userMapper.mapDbModelToEntity(dbModel)
    }

    override fun getUserList(): LiveData<List<User>> = Transformations.map(
        userDao.getUserList()
    ) { userMapper.mapListDbModelToListEntity(it) }
}