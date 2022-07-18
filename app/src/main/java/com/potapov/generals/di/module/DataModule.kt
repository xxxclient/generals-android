package com.potapov.generals.di.module

import android.app.Application
import com.potapov.generals.data.repository.UserRepositoryImpl
import com.potapov.generals.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserRepository(application: Application): UserRepository {
        return UserRepositoryImpl(application)
    }
}