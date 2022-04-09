package com.coolme.me.square18.uiLayer.widget.forgetPassword

import androidx.compose.runtime.Composable
import com.coolme.me.square18.uiLayer.component.TextFieldShoUsername
import com.coolme.me.square18.uiLayer.screen.forgetPassword.ForgetPasswordVM

@Composable
fun UsernameForForgetPassword(
    vM: ForgetPasswordVM,
                    )
{
    TextFieldShoUsername(
        username = vM.uiState.username,
        onUsernameChange = {vM.onUsernameChange(newUsername = it)},
                        )
}
