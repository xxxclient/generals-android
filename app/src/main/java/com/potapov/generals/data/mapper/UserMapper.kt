package com.potapov.generals.data.mapper

import com.potapov.generals.data.db_model.UserDbModel
import com.potapov.generals.domain.entity.User

class UserMapper {

    fun mapEntityToDbModel(user: User) = UserDbModel(
        id = user.id,
        race = user.race
    )

    fun mapDbModelToEntity(userDbModel: UserDbModel) = User(
        id = userDbModel.id,
        race = userDbModel.race
    )

    fun mapListDbModelToListEntity(list: List<UserDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}