package com.example.onlineshop.viewModel

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {


    private val _stateLogin = MutableStateFlow<Boolean>(false)
    val stateLogin: StateFlow<Boolean> = _stateLogin

    private val _stateRegister = MutableStateFlow<Boolean>(false)
    val stateRegister: StateFlow<Boolean> = _stateRegister


    private val _message = MutableSharedFlow<String>()
    val message: SharedFlow<String> = _message


    fun login(
        username: String,
        pass: String
    ) {  //فانکشنی توی ویو مدل تعریف میکنیم ورودیش یوزر و پسورد میگیره
        viewModelScope.launch {                      // کارش اینه دیتا ولیدیشن رو چک میکنه اگر تورو بود اون مسیج رو ولکام
            _stateLogin.value = repository.userDataValidation(username, pass)
            _message.emit(
                if (_stateLogin.value) {
                    "خوش آمدید"
                } else
                    "اطلاعات اشتباه است"
            )

            // میزاره اگر فالس بود نات ولید میزاره

        }
    }


    fun register(fullName: String, phone: String, email: String, username: String, pass: String) {
        viewModelScope.launch {
            if (username.isNotBlank() && pass.isNotBlank() && phone.isNotBlank() && email.isNotBlank() && fullName.isNotBlank()) {
                repository.setUserData(fullName, phone, email, username, pass)
                _stateRegister.value = true

            }
         

        }


    }


}