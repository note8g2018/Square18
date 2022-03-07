package com.coolme.me.square18.uiLayer.screen.registration

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.coolme.me.square18.domainLayer.registration.RegistrationVM
import com.coolme.me.square18.uiLayer.component.SnackbarHostSho
import com.coolme.me.square18.uiLayer.widget.Email
import com.coolme.me.square18.uiLayer.widget.Password
import com.coolme.me.square18.uiLayer.widget.Username

@Composable
fun Registration(
    navController: NavController,
                )
{
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    var screenWidth : Int by remember { mutableStateOf(0) }

    Registration(
        navController = navController,
        focusRequester = focusRequester,
        scaffoldState = rememberScaffoldState(),
        screenWidth = screenWidth,
        onScreenWidthChange = {
            screenWidth = it.size.width
        },
                )
}

@Composable
fun Registration(
    registrationVM: RegistrationVM = viewModel(),
    navController: NavController,
    focusRequester: FocusRequester,
    scaffoldState: ScaffoldState,
    screenWidth : Int = 100,
    onScreenWidthChange: (LayoutCoordinates) -> Unit,
                )
{
    //var screenWidth : Int by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .focusRequester(focusRequester)
            .focusTarget()
            .pointerInput(Unit) { detectTapGestures { focusRequester.requestFocus() } }
            .onGloballyPositioned {
                onScreenWidthChange(it)
            },
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHostSho(hostState = scaffoldState.snackbarHostState)
        },
        topBar = { TopBarRegistration(navController = navController) },
            )
    {
        Box( modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
           )
        {
            Username(
                username = registrationVM.uiState.username,
                onUsernameChange = {registrationVM.onUsernameChange(
                    registrationVM.uiState.username
                                                                   )},
                hasError = registrationVM.uiState.usernameHasError,
                xOffset = 0.dp,
                onNext = {}
                    )
            Email(
                email = registrationVM.uiState.email,
                onEmailChange = {registrationVM.uiState.onEmailChange(
                    registrationVM.uiState.email
                                                                     )},
                hasError = registrationVM.uiState.emailHasError,
                xOffset = 100.dp + Dp(screenWidth.toFloat()),
                onNext = { /*TODO*/ },
                onBack = {},
                 )
            Password(
                password1 = registrationVM.uiState.password1,
                onPassword1Change = { registrationVM.uiState.onPassword1Change(
                    registrationVM.uiState.password1
                                                                              )},
                password2 = registrationVM.uiState.password2,
                onPassword2Change = { registrationVM.uiState.onPassword2Change(
                    registrationVM.uiState.password2
                                                                              )},
                hasError = registrationVM.uiState.passwordHasError,
                xOffset = 200.dp,
                onNext = { /*TODO*/ },
                onBack = {},
                    )
//            Email(
//                registerVM = registerVM,
//                onNext = {
//                    xOffsetState = Dp(-0.35f * screenWidth.toFloat())
//                },
//                xOffset = xOffset,
//                 )
//            Password(
//                registerVM = registerVM,
//                screenWidth = screenWidth,
//                onBack = {
//                    xOffsetState = 0.dp // Dp(0.35f * screenWidth.toFloat())
//                },
//                onNext = {
//                    xOffsetState = Dp(-0.35f * 2.0f * screenWidth.toFloat())
//                },
//                xOffset = xOffset,
//                    )
//            Username(
//                registerVM = registerVM,
//                screenWidth = screenWidth,
//                onBack = {
//                    xOffsetState = Dp(-0.35f * screenWidth.toFloat())
//                },
//                onNext = {
//
//                },
//                xOffset = xOffset,
//                                 )


        }
    }
}