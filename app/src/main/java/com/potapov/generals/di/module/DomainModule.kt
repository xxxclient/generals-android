package com.potapov.generals.di.module

import com.potapov.generals.domain.repository.UserRepository
import com.potapov.generals.domain.usecase.UserUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideUserUseCase(userRepository: UserRepository): UserUseCase {
        return UserUseCase(userRepository)
    }
}