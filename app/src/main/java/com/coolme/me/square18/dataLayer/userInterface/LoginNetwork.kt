package com.coolme.me.square18.dataLayer.userInterface

import com.coolme.me.square18.dataLayer.model.ResultSho
import com.coolme.me.square18.dataLayer.model.User
import com.coolme.me.square18.uiLayer.screen.login.LoginUiState
import kotlinx.coroutines.flow.Flow

interface LoginNetwork
{
    suspend fun login(loginUiState: LoginUiState): Flow<ResultSho<User>>

    suspend fun logout(user: User): Flow<ResultSho<User>>
}