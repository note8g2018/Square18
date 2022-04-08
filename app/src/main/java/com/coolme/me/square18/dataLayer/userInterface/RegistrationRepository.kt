package com.coolme.me.square18.dataLayer.userInterface

import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.uiLayer.screen.registration.RegistrationUiState
import kotlinx.coroutines.flow.Flow

interface RegistrationRepository
{
    suspend fun submit(registrationUiState: RegistrationUiState) : Flow<ResultSho<User>>
}