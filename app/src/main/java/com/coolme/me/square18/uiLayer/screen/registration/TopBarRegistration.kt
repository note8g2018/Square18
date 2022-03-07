package com.coolme.me.square18.uiLayer.screen.registration

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.coolme.me.square18.uiLayer.component.LeftIconButtonTopBar
import com.coolme.me.square18.uiLayer.component.TopBar

@Composable
fun TopBarRegistration(navController: NavController)
{
    TopBar(
        title = "Registration",
        leftIconButtonTopBar = { LeftIconButtonTopBar(navController = navController) }
          )
}