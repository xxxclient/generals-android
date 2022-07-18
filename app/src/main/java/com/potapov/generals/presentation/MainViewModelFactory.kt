package com.potapov.generals.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.potapov.generals.domain.usecase.UserUseCase

class MainViewModelFactory(
    private val application: Application,
    private val userUseCase: UserUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(application, userUseCase) as T
    }
}