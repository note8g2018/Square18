package com.coolme.me.square18.dataLayer.userInterface

import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.uiLayer.screen.forgetPassword.ForgetPasswordUiState
import com.coolme.me.square18.uiLayer.screen.registration.RegistrationUiState
import com.coolme.me.square18.uiLayer.screen.resetPassword.ResetPasswordUiState
import kotlinx.coroutines.flow.Flow

interface RegistrationRepository
{
    suspend fun submit(registrationUiState: RegistrationUiState) : Flow<ResultSho<User>>

    suspend fun forgetPassword(forgetPasswordUiState: ForgetPasswordUiState)
    : Flow<ResultSho<String>>

    suspend fun resetPassword(resetPasswordUiState: ResetPasswordUiState)
            : Flow<ResultSho<String>>
}