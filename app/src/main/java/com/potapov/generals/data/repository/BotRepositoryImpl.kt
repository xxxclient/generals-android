package com.potapov.generals.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.potapov.generals.data.dao.BotDao
import com.potapov.generals.data.mapper.BotMapper
import com.potapov.generals.domain.entity.Bot
import com.potapov.generals.domain.repository.BotRepository
import javax.inject.Inject

class BotRepositoryImpl @Inject constructor(
    private val botDao: BotDao,
    private val botMapper: BotMapper
) : BotRepository {

    override suspend fun addBot(bot: Bot) {
        botDao.addBot(botMapper.mapEntityToDbModel(bot))
    }

    override suspend fun deleteBot(bot: Bot) {
        botDao.deleteBot(bot.id)
    }

    override suspend fun editBot(bot: Bot) {
        botDao.addBot(botMapper.mapEntityToDbModel(bot))
    }

    override suspend fun getBot(botId: Int): Bot {
        val dbModel = botDao.getBot(botId)
        return botMapper.mapDbModelToEntity(dbModel)
    }

    override fun getBotList(): LiveData<List<Bot>> = Transformations.map(
        botDao.getBotList()
    ) { botMapper.mapListDbModelToListEntity(it) }
}