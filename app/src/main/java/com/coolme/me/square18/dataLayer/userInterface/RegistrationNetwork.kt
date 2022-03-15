package com.coolme.me.square18.dataLayer.userInterface

import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.domainLayer.registration.RegistrationUiState
import kotlinx.coroutines.flow.Flow

interface RegistrationNetwork : NetworkSho
{
   suspend fun registerUser(registrationUiState: RegistrationUiState): Flow<ResultSho<User>>
}