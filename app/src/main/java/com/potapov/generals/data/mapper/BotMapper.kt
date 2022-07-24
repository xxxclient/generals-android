package com.potapov.generals.data.mapper

import com.potapov.generals.data.db_model.BotDbModel
import com.potapov.generals.domain.entity.Bot

class BotMapper {

    fun mapEntityToDbModel(bot: Bot) = BotDbModel(
        id = bot.id,
        race = bot.race,
        level = bot.level
    )

    fun mapDbModelToEntity(botDbModel: BotDbModel) = Bot(
        id = botDbModel.id,
        race = botDbModel.race,
        level = botDbModel.level
    )

    fun mapListDbModelToListEntity(list: List<BotDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}