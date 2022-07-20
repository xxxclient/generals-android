package com.potapov.generals.di.module

import com.potapov.generals.domain.repository.UserRepository
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
}