package com.coolme.me.square18.uiLayer.component

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.coolme.me.square18.uiLayer.theme.Error

@Composable
fun SnackbarSho(
    snackbarData: SnackbarData,
    modifier: Modifier = Modifier,
    action: @Composable (() -> Unit)? = null,
    actionOnNewLine: Boolean = false,
    shape: Shape = MaterialTheme.shapes.small,
    backgroundColor: Color = Error,
    contentColor: Color = MaterialTheme.colors.surface,
    elevation: Dp = 6.dp,
    //content: @Composable () -> Unit
                )
{
    Snackbar(
        modifier = modifier,
        action = action,
        actionOnNewLine = actionOnNewLine,
        shape = shape,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        //content = content,
    )
    {
        Text(text= snackbarData.message)
    }
}

@Composable
fun SnackbarHostSho(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
                )
{
    SnackbarHost(
        hostState = hostState,
        modifier = modifier
                ) {
        SnackbarSho(it)
    }
}

