package com.coolme.me.square18.uiLayer.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.coolme.me.square18.uiLayer.theme.BarIcon

@Composable
fun LeftIconButtonTopBar(navController: NavController)
{
    IconButton(
        onClick = {
            navController.popBackStack()
        },
              )
    {
        Icon(
            modifier = Modifier.size(BarIcon),
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Backward",
            )
    }
}