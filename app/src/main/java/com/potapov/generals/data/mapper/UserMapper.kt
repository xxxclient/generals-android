package com.potapov.generals.data.mapper

import com.potapov.generals.data.db_model.UserDbModel
import com.potapov.generals.domain.entity.User

class UserMapper {

    fun mapEntityToDbModel(user: User) = UserDbModel(
        userId = user.userId,
        name = user.name
    )

    fun mapDbModelToEntity(userDbModel: UserDbModel) = User(
        userId = userDbModel.userId,
        name = userDbModel.name
    )

    fun mapListDbModelToListEntity(list: List<UserDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}