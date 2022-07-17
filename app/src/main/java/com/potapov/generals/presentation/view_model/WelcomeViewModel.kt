package com.potapov.generals.presentation.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.potapov.generals.data.repository.UserRepositoryImpl
import com.potapov.generals.domain.usecase.UserUseCase

class WelcomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepositoryImpl(application)

    private val userUseCase = UserUseCase(repository)

    val userList = userUseCase.getUserList()
}