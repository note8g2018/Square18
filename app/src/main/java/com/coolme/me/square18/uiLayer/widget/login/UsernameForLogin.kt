package com.coolme.me.square18.uiLayer.widget.login

import androidx.compose.runtime.Composable
import com.coolme.me.square18.uiLayer.component.TextFieldShoUsername
import com.coolme.me.square18.uiLayer.screen.login.LoginVM

@Composable
fun UsernameForLogin(
    vM: LoginVM,
            )
{
    TextFieldShoUsername(
        username = vM.uiState.username,
        onUsernameChange = {vM.onUsernameChange(newUsername = it)},
            )
}
