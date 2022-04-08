package com.coolme.me.square18.uiLayer.widget.login

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.coolme.me.square18.uiLayer.component.TextFieldSho
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

@Composable
fun TextFieldShoPassword(
    password: String,
    onPasswordChange: (String) -> Unit,
    onSend: ()-> Unit,
            )
{
    TextFieldSho(
        value = password,
        onValueChange = onPasswordChange,
        label = "Password",
        icon = Icons.Filled.Password,
        visualTransformation = PasswordVisualTransformation(mask = '*'),
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Send,
        keyboardActions = KeyboardActions(
            onSend = {onSend()},
                                         )
                )
}


