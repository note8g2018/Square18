package com.coolme.me.square18.dataLayer.fuckInterface

import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.domainLayer.registration.RegistrationUiState
import kotlinx.coroutines.flow.Flow

interface RegistrationRepository
{
    suspend fun submit(registrationUiState: RegistrationUiState) : Flow<ResultSho<User>>
}