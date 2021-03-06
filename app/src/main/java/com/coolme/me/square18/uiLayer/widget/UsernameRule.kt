package com.coolme.me.square18.uiLayer.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.coolme.me.square18.uiLayer.theme.StyleRole

@Composable
fun UsernameRule()
{
    Row()
    {
        Text(
            text = "1. ",
            style = StyleRole,
            )
        Text(
            text = "At least 8 characters [8, 31]",
            style = StyleRole,
            )
    }
    Row()
    {
        Text(
            text = "2. ",
            style = StyleRole,
            )
        Text(
            text = "The first 5 characters must be from [a, z]",
            style = StyleRole,
            )
    }

    Row()
    {
        Text(
            text = "3. ",
            style = StyleRole,
            )
        Text(
            text = "The rest characters must be from [a, z] or [0, 9]",
            style = StyleRole,
            )
    }
}