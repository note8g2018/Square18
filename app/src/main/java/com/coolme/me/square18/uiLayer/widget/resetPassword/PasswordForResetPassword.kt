package com.coolme.me.square18.uiLayer.widget.resetPassword

import androidx.compose.runtime.Composable
import com.coolme.me.square18.uiLayer.component.TextFieldShoPassword
import com.coolme.me.square18.uiLayer.screen.resetPassword.ResetPasswordVM

@Composable
fun PasswordForResetPassword(
    vM: ResetPasswordVM,
    onSend: ()-> Unit,
                    )
{
    TextFieldShoPassword(
        password = vM.uiState.newPassword,
        onPasswordChange = {vM.onNewPasswordChange(newNewPassword = it)},
        onSend = onSend,
                        )
}