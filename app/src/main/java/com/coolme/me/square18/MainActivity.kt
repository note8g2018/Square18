package com.coolme.me.square18

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coolme.me.square18.uiLayer.screen.registration.Registration
import com.coolme.me.square18.uiLayer.theme.Square18Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //installSplashScreen()

        setContent {
            Square18Theme(darkTheme = true)
            {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation()
{
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Registration"
           )
    {
        //composable(route= "Login") { Login(navController = navController) }
        composable(route= "Registration") { Registration(navController = navController) }
        //composable(route= "Wall") { Wall(navController = navController) }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview()
{
    Square18Theme {
        Navigation()
    }
}