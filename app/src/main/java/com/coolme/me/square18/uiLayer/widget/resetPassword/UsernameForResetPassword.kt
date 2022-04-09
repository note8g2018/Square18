package com.coolme.me.square18.uiLayer.widget.resetPassword

import androidx.compose.runtime.Composable
import com.coolme.me.square18.uiLayer.component.TextFieldShoUsername
import com.coolme.me.square18.uiLayer.screen.resetPassword.ResetPasswordVM

@Composable
fun UsernameForResetPassword(
    vM: ResetPasswordVM,
                             )
{
    TextFieldShoUsername(
        username = vM.uiState.username,
        onUsernameChange = {vM.onUsernameChange(newUsername = it)},
                        )
}
