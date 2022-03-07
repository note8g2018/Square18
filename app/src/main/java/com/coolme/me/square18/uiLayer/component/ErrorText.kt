package com.coolme.me.square18.uiLayer.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.coolme.me.square18.uiLayer.theme.StyleError

@Composable
fun ErrorText(
    hasError: Boolean = false,
    errorMessage: String,
             )
{
    if (hasError)
    {
        Text(
            text = errorMessage,
            style = StyleError,
            )
    }
}