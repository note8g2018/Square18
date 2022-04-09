package com.coolme.me.square18.uiLayer.screen.resetPassword

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.square18.uiLayer.component.LeftIconButtonTopBar
import com.coolme.me.square18.uiLayer.component.TopBar

@Composable
fun TopBarResetPassword(navController: NavController)
{
    TopBar(
        title = "Reset Password",
        leftIconButtonTopBar = { LeftIconButtonTopBar(navController = navController) }
          )
}