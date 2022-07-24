package com.potapov.generals.di.module

import com.potapov.generals.domain.repository.BotRepository
import com.potapov.generals.domain.repository.UserRepository
import com.potapov.generals.domain.usecase.BotUseCase
import com.potapov.generals.domain.usecase.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideUserUseCase(userRepository: UserRepository): UserUseCase =
            UserUseCase(userRepository)

    @Provides
    fun provideBotUseCase(botRepository: BotRepository): BotUseCase =
            BotUseCase(botRepository)
}