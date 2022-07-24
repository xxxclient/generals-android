package com.potapov.generals.domain.repository

import androidx.lifecycle.LiveData
import com.potapov.generals.domain.entity.Bot

interface BotRepository {

    suspend fun addBot(user: Bot)
    suspend fun deleteBot(user: Bot)
    suspend fun editBot(user: Bot)
    suspend fun getBot(botId: Int): Bot
    fun getBotList(): LiveData<List<Bot>>
}