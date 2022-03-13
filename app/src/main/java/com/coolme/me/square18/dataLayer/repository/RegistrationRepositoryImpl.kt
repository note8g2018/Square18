package com.coolme.me.square18.dataLayer.repository

import com.coolme.me.square18.dataLayer.fuckInterface.RegistrationNetwork
import com.coolme.me.square18.dataLayer.fuckInterface.RegistrationRepository
import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.domainLayer.registration.RegistrationUiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val registrationNetwork: RegistrationNetwork,
                                                    ) : RegistrationRepository
{
    override suspend fun submit(registrationUiState: RegistrationUiState) : Flow<ResultSho<User>>
    {
        return registrationNetwork.registerUser(registrationUiState)
//        return flow {
//            emit(ResultSho.Progressing)
//        }
    }
}