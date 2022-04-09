package com.coolme.me.square18.uiLayer.widget.resetPassword

import androidx.compose.runtime.Composable
import com.coolme.me.square18.uiLayer.component.TextFieldShoUsername
import com.coolme.me.square18.uiLayer.screen.resetPassword.ResetPasswordVM

@Composable
fun ResetCodeForResetPassword(
    vM: ResetPasswordVM,
                            )
{
    TextFieldShoUsername(
        label = "Reset Code",
        username = vM.uiState.resetCode,
        onUsernameChange = {vM.onResetCodeChange(newResetCode = it)},
                        )
}
