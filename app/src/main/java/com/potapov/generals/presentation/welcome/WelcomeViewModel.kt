package com.potapov.generals.presentation.welcome

import androidx.lifecycle.ViewModel
import com.potapov.generals.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    val userList = userUseCase.getUserList()
}