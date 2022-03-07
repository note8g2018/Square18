package com.coolme.me.square18.domainLayer.registration

import com.coolme.me.square18.domainLayer.validation.isEmailValid
import com.coolme.me.square18.domainLayer.validation.isPasswordValid
import com.coolme.me.square18.domainLayer.validation.isUsernameValid
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationUiState(
    val username : String = "",
    val email : String = "",
    val password1 : String = "",
    val password2 : String = "",
    val usernameHasError : Boolean = false,
    val passwordHasError : Boolean = false,
    val emailHasError : Boolean = false,
    val progressing : Boolean = false,
    val shouldShowSnackBar: Boolean = false,
                              )
{
    fun onUsernameChange(newUsername: String)
    {
        this.copy(username = newUsername)
        //username = newUsername
    }
    fun validateUsername()
    {
        this.copy(usernameHasError = !isUsernameValid(username = username))
        //usernameHasError.value = !isUsernameValid(username= username.value)
    }
    fun onPassword1Change(newPassword: String)
    {
        this.copy(password1 = newPassword)
        //password1.value = newPassword
    }
    fun onPassword2Change(newPassword: String)
    {
        this.copy(password2 = newPassword)
        //password2.value = newPassword
    }
    fun validatePassword()
    {
        this.copy(passwordHasError = !isPasswordValid(password1 = password1, password2
                                                     = password2))
    }
    fun onEmailChange(newEmail: String)
    {
        this.copy(email = newEmail)
        //email.value = newEmail
    }
    fun validateEmail()
    {
        this.copy(emailHasError = !isEmailValid(email= email))
        //emailHasError.value = !isEmailValid(email.value)
    }
    fun toJson(): Map<String, Any>
    {
        return mapOf(
            "username" to username,
            "email" to email,
            "password" to password1,
                    )
    }
}
