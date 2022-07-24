package com.potapov.generals.di.module

import android.content.Context
import com.potapov.generals.data.dao.BotDao
import com.potapov.generals.data.dao.UserDao
import com.potapov.generals.data.database.AppDatabase
import com.potapov.generals.data.mapper.BotMapper
import com.potapov.generals.data.mapper.UserMapper
import com.potapov.generals.data.repository.BotRepositoryImpl
import com.potapov.generals.data.repository.UserRepositoryImpl
import com.potapov.generals.domain.repository.BotRepository
import com.potapov.generals.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserDao(@ApplicationContext context: Context): UserDao =
            AppDatabase.getInstance(context).userDao()

    @Provides
    fun provideUserMapper(): UserMapper = UserMapper()

    @Provides
    fun provideUserRepository(userDao: UserDao, userMapper: UserMapper): UserRepository =
            UserRepositoryImpl(userDao, userMapper)

    @Provides
    @Singleton
    fun provideBotDao(@ApplicationContext context: Context): BotDao =
            AppDatabase.getInstance(context).botDao()

    @Provides
    fun provideBotMapper(): BotMapper = BotMapper()

    @Provides
    fun provideBotRepository(botDao: BotDao, botMapper: BotMapper): BotRepository =
            BotRepositoryImpl(botDao, botMapper)
}