package com.coolme.me.square18

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coolme.me.square18.dataLayer.model.Screen
import com.coolme.me.square18.dataLayer.model.UserRealm
import com.coolme.me.square18.dataLayer.userInterface.LocalDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavHostShoVM @Inject constructor(
    private val localDatabase: LocalDatabase,
                                      ) : ViewModel()
{
    var isLoading by mutableStateOf<Boolean>(true)
        private set

    var startDestination by mutableStateOf<String>(Screen.Login.route)
        private set

    init
    {
        viewModelScope.launch {
            val userRealm : UserRealm? = localDatabase.getUserRealm()
            if(userRealm != null)
            {
                if(userRealm.isLogin)
                {
                    startDestination = Screen.Wall.route
                }
            }
            isLoading = false
        }
    }
}