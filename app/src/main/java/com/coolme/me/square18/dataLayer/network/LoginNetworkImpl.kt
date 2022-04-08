package com.coolme.me.square18.dataLayer.network

import com.coolme.me.square18.dataLayer.model.ErrorSho
import com.coolme.me.square18.dataLayer.model.ResponseSho
import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.dataLayer.userInterface.LoginNetwork
import com.coolme.me.square18.uiLayer.screen.login.LoginUiState
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginNetworkImpl @Inject constructor() : LoginNetwork
{
    override suspend fun login(loginUiState: LoginUiState): Flow<ResultSho<User>>
    {
        val ktorClient : KtorClient = KtorClient()
        return flow<ResultSho<User>> {
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<User> = ktorClient.httpClient.use {
                    it.post {
                        this.url {
                            this.path("login")
                        }
                        this.body = loginUiState.toJson()
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

    override suspend fun logout(user: User): Flow<ResultSho<User>>
    {
        val ktorClient : KtorClient = KtorClient()
        return flow<ResultSho<User>> {
            emit(ResultSho.Progressing)
            try
            {
                val responseSho: ResponseSho<User> = ktorClient.httpClient.use {
                    it.post {
                        this.url {
                            this.path("logout")
                        }
                        this.body = user
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
                    val user2: User = responseSho.data as User
                    //user2.token = responseSho.token!!
                    emit(ResultSho.Success(data = user2))
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