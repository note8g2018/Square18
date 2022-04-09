package com.coolme.me.square18.uiLayer.widget.login

import androidx.compose.runtime.Composable
import com.coolme.me.square18.uiLayer.component.TextFieldShoPassword
import com.coolme.me.square18.uiLayer.screen.login.LoginVM

@Composable
fun PasswordForLogin(
    vM: LoginVM,
    onSend: ()-> Unit,
            )
{
    TextFieldShoPassword(
        password = vM.uiState.password,
        onPasswordChange = {vM.onPasswordChange(newPassword = it)},
        onSend = onSend,
            )
}




