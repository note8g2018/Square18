package com.coolme.me.square18.dataLayer.network

import com.coolme.me.square18.dataLayer.model.ErrorSho
import com.coolme.me.square18.dataLayer.model.ResponseSho
import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.dataLayer.userInterface.RegistrationNetwork
import com.coolme.me.square18.uiLayer.screen.registration.RegistrationUiState
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegistrationNetworkImpl @Inject constructor() : RegistrationNetwork
{
    override suspend fun registerUser(registrationUiState: RegistrationUiState)
    : Flow<ResultSho<User>>
    {
        val ktorClient = KtorClient()
        return flow {
            println("Flow")
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<User> = ktorClient.httpClient.use {
                    it.post {
                            this.url {
                                this.path("register")
                            }
                            this.body =
                                registrationUiState.toJson()
                        }
                }
                ktorClient.httpClient.close()
                    if (responseSho.error)
                    {
                        emit( ResultSho.Failure( ErrorSho(
                            error = true,
                            statusCode = responseSho.statusCode,
                            message = responseSho.errorMessage!!,
                            type = "Server Side",
                                                         )
                                               )
                            )
                    }
                    else
                    {
                        val user: User = responseSho.data as User
                        user.token = responseSho.token!!
                        emit(ResultSho.Success(data = user))
                    }

            }
            catch (e :Exception)
            {
                emit( ResultSho.Failure( ErrorSho(
                    error = true,
                    statusCode = 700,
                    message = e.message!!,
                    type = "Client Side",
                                                 )
                                       )
                    )
            }
        }
    }
}
