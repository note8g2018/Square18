package com.coolme.me.square18.uiLayer.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.coolme.me.square18.uiLayer.component.ErrorText
import com.coolme.me.square18.uiLayer.component.RightButton
import com.coolme.me.square18.uiLayer.component.TextFieldSho
import com.coolme.me.square18.uiLayer.modifierExtention.shadowWithColor
import com.coolme.me.square18.uiLayer.theme.*

@Composable
fun Username(
    username: String,
    onUsernameChange: (username: String) -> Unit,
    hasError: Boolean = false,
    xOffset: Dp,
    onNext: () -> Unit,
            )
{
    Box(
        modifier = Modifier
            .offset(
                //x = xOffset + Dp(0.35f * 2 * screenWidth.toFloat()),
                x = xOffset,
                y = 0.dp
                   )
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
            TextFieldSho(
                value = username,
                onValueChange = onUsernameChange,
                label = "Username" ,
                icon = Icons.Filled.Create,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {onNext()},
                                                 )
                        )
            ErrorText(hasError = hasError, errorMessage = "This is NOT valid Username" )
            UsernameRule()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
               )
            {
                RightButton(onNext = onNext)
            }
        }
    }
}


//***************************************
//***************************************

@Preview(showBackground = true)
@Composable
fun DefaultPreview()
{
    Username(username = "AAAA", onUsernameChange = {}, xOffset = 0.dp){}
}
