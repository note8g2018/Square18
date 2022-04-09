package com.coolme.me.square18.uiLayer.screen.forgetPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.input.pointer.pointerInput
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.coolme.me.square18.uiLayer.component.SnackbarHostSho
import com.coolme.me.square18.uiLayer.modifierExtention.shadowWithColor
import com.coolme.me.square18.uiLayer.theme.*
import com.coolme.me.square18.uiLayer.widget.CircleProgressIndicator
import com.coolme.me.square18.uiLayer.widget.forgetPassword.UsernameForForgetPassword

@Composable
fun ForgetPassword(navController: NavController)
{
    val focusRequester by remember { mutableStateOf(FocusRequester()) }

    ForgetPassword(
        navController = navController,
        focusRequester = focusRequester,
        scaffoldState = rememberScaffoldState(),
         )
}

@Composable
fun ForgetPassword(
    vM: ForgetPasswordVM = hiltViewModel(),
    navController: NavController,
    focusRequester: FocusRequester,
    scaffoldState: ScaffoldState,
         )
{
    Scaffold(
        modifier = Modifier
                .focusRequester(focusRequester)
                .focusTarget()
                .pointerInput(Unit) { detectTapGestures { focusRequester.requestFocus() } },
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHostSho(hostState = scaffoldState.snackbarHostState)
        },
        topBar = { TopBarForgetPassword(navController) },
            )
    {
        Column(
            modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())

              )
        {
            Box(
                modifier = Modifier
                        .padding(PaddingAll)
                        .fillMaxWidth()
                        .shadowWithColor(
                            color = TopBarContent,
                            shadowRadius = ShadowRadius,
                                        )
                        .background(color = BoxBackground)
               )
            {
                Column(
                    modifier = Modifier
                            .padding(PaddingColumn)
                            .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(space = SpaceColumnHeight),
                      )
                {
                    UsernameForForgetPassword(vM = vM)
                    ForgetButton(onClick = {vM.forgetPassword(scaffoldState, navController) })
                }

                if(vM.uiState.progressing)
                {
                    CircleProgressIndicator()
                }
            }
        }
    }
}