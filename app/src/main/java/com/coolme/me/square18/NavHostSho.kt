package com.coolme.me.square18

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coolme.me.square18.dataLayer.model.Screen
import com.coolme.me.square18.uiLayer.screen.forgetPassword.ForgetPassword
import com.coolme.me.square18.uiLayer.screen.login.Login
import com.coolme.me.square18.uiLayer.screen.registration.Registration
import com.coolme.me.square18.uiLayer.screen.resetPassword.ResetPassword
import com.coolme.me.square18.uiLayer.screen.wall.Wall

@Composable
fun NavHostSho(vM: NavHostShoVM = hiltViewModel())
{
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = vM.startDestination,
           )
    {
        composable(route= Screen.Login.route) { Login(navController = navController) }
        composable(route= Screen.Registration.route) { Registration(navController = navController) }
        composable(route= Screen.Wall.route) { Wall(navController = navController) }
        composable(route= Screen.ForgetPassword.route) { ForgetPassword(navController = navController) }
        composable(route= Screen.ResetPassword.route) { ResetPassword(navController = navController) }
    }
}