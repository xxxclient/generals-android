package com.potapov.generals.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.potapov.generals.domain.usecase.UserUseCase

class MainViewModel(
    application: Application,
    userUseCase: UserUseCase
) : AndroidViewModel(application) {

}