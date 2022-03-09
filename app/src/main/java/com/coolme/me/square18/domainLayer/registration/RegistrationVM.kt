package com.coolme.me.square18.domainLayer.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.coolme.me.square18.domainLayer.validation.isEmailValid
import com.coolme.me.square18.domainLayer.validation.isPasswordValid
import com.coolme.me.square18.domainLayer.validation.isUsernameValid
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationVM @Inject constructor() : ViewModel()
{
    var uiState by mutableStateOf(RegistrationUiState())
        private set

    fun onUsernameChange(newUsername: String)
    {
        uiState = uiState.copy(username = newUsername)
    }
    fun validateUsername()
    {
        uiState = uiState.copy(usernameHasError = !isUsernameValid(
            username = uiState.username))
    }
    fun onPassword1Change(newPassword: String)
    {
        uiState = uiState.copy(password1 = newPassword)
    }
    fun onPassword2Change(newPassword: String)
    {
        uiState = uiState.copy(password2 = newPassword)
    }
    fun validatePassword()
    {
        uiState = uiState.copy(
            passwordHasError = !isPasswordValid(password1 = uiState.password1,
                                                password2 = uiState.password2)
                 )
    }
    fun onEmailChange(newEmail: String)
    {
        uiState = uiState.copy(email = newEmail)
    }
    fun validateEmail()
    {
        uiState = uiState.copy(emailHasError = !isEmailValid(email= uiState.email))
    }
    fun onUsernameNext()
    {
        validateUsername()
    }
}