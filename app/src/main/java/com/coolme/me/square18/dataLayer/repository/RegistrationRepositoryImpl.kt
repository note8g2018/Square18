package com.coolme.me.square18.dataLayer.repository

import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.dataLayer.userInterface.LocalDatabase
import com.coolme.me.square18.dataLayer.userInterface.RegistrationNetwork
import com.coolme.me.square18.dataLayer.userInterface.RegistrationRepository
import com.coolme.me.square18.uiLayer.screen.registration.RegistrationUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val registrationNetwork: RegistrationNetwork,
    private val localDatabase: LocalDatabase,
                                                    ) : RegistrationRepository
{
    override suspend fun submit(registrationUiState: RegistrationUiState)
    : Flow<ResultSho<User>>
    {
        val result = registrationNetwork.registerUser(registrationUiState)
        return flow {
            result.collect{value ->
                when (value)
                {
                    is ResultSho.Failure     ->
                    {
                        emit(value)
                    }
                    is ResultSho.Progressing ->
                    {
                        emit(value)
                    }
                    is ResultSho.Success     ->
                    {
                        val job: Job = CoroutineScope(Dispatchers.IO).launch {
                            localDatabase.saveOrUpdateUser(value.data)
                        }
                        job.join()
                        emit(value)
                    }
                }
            }
        }
    }
}