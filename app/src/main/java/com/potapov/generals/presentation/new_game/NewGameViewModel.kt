package com.potapov.generals.presentation.new_game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.potapov.generals.domain.entity.Bot
import com.potapov.generals.domain.entity.User
import com.potapov.generals.domain.usecase.BotUseCase
import com.potapov.generals.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewGameViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
    private val botUseCase: BotUseCase
) : ViewModel() {

    val userList = userUseCase.getUserList()

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    private val _shouldStartGame = MutableLiveData<Unit>()
    val shouldStartGame: LiveData<Unit>
        get() = _shouldStartGame

    fun getUser(userId: Int) {
        viewModelScope.launch {
            val user = userUseCase.getUser(userId)
            _user.value = user
        }
    }

    fun addUser(inputRace: String?) {
        val race = parseName(inputRace)
        val fieldsValid = validateInput(race)
        if (fieldsValid) {
            viewModelScope.launch {
                val user = User(race = race)
                userUseCase.addUser(user)
//                startGame()
            }
        }
    }

    fun addBot(inputRace: String?) {
        val race = parseName(inputRace)
        val fieldsValid = validateInput(race)
        if (fieldsValid) {
            viewModelScope.launch {
                val bot = Bot(race = race, level = 1)
                botUseCase.addBot(bot)
                // TODO: Добавить или общий метод добавления юзера и бота или общую валидацию ввода
                startGame()
            }
        }
    }

    fun editUser(inputRace: String?) {
        val race = parseName(inputRace)
        val fieldsValid = validateInput(race)
        if (fieldsValid) {
            _user.value?.let {
                viewModelScope.launch {
                    val user = it.copy(race = race)
                    userUseCase.editUser(user)
                    startGame()
                }

            }
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun validateInput(name: String): Boolean {
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }

    private fun startGame() {
        _shouldStartGame.value = Unit
    }
}