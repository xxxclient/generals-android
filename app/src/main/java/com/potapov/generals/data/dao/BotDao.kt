package com.potapov.generals.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.potapov.generals.data.db_model.BotDbModel
import com.potapov.generals.data.db_model.UserDbModel

@Dao
interface BotDao {

    @Query("SELECT * FROM bots")
    fun getBotList(): LiveData<List<BotDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBot(botDbModel: BotDbModel)

    @Query("DELETE FROM bots WHERE id = :botId")
    suspend fun deleteBot(botId: Int)

    @Query("SELECT * FROM bots WHERE id = :botId LIMIT 1")
    suspend fun getBot(botId: Int): BotDbModel
}