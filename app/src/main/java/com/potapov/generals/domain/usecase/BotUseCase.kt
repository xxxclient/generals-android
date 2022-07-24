package com.potapov.generals.domain.usecase

import androidx.lifecycle.LiveData
import com.potapov.generals.domain.entity.Bot
import com.potapov.generals.domain.repository.BotRepository
import javax.inject.Inject

class BotUseCase @Inject constructor(
    private val botRepository: BotRepository
) {

    suspend fun addBot(bot: Bot) {
        botRepository.addBot(bot)
    }

    suspend fun deleteBot(bot: Bot) {
        botRepository.deleteBot(bot)
    }

    suspend fun editBot(bot: Bot) {
        botRepository.editBot(bot)
    }

    suspend fun getBot(botId: Int): Bot {
        return botRepository.getBot(botId)
    }

    fun getBotList(): LiveData<List<Bot>> {
        return botRepository.getBotList()
    }
}