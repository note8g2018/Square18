package com.coolme.me.square18.uiLayer.widget.login

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.coolme.me.square18.uiLayer.component.TextFieldSho
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

@Composable
fun TextFieldShoUsername(
    username: String,
    onUsernameChange: (String) -> Unit,
            )
{
    TextFieldSho(
        value = username,
        onValueChange = onUsernameChange,
        label = "Username",
        icon = Icons.Filled.Create,
        keyboardType = KeyboardType.Text,
                )
}


//*****************************************
