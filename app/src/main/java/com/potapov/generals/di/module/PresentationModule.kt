package com.potapov.generals.di.module

import android.app.Application
import com.potapov.generals.domain.usecase.UserUseCase
import com.potapov.generals.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(val application: Application) {

    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    fun provideMainViewModelFactory(
        application: Application,
        userUseCase: UserUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(application, userUseCase)
    }
}