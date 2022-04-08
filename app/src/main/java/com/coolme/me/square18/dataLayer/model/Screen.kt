package com.coolme.me.square18.dataLayer.model

sealed class Screen(val route: String)
{
    object Login : Screen(route = "login")
    object Registration : Screen(route = "registration")
    object Wall : Screen(route = "wall")
}
