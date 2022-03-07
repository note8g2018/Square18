package com.coolme.me.square18.domainLayer.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationVM @Inject constructor() : ViewModel()
{
    var uiState by mutableStateOf(RegistrationUiState())
        private set

    fun onUsernameChange(newUsername: String) : RegistrationUiState
    {
        return this.uiState.copy(username = newUsername)
        //uiState.copy(username = newUsername)
        //this.copy(username = newUsername)
        //username = newUsername
    }

}