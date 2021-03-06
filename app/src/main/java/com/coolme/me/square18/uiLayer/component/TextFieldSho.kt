package com.coolme.me.square18.uiLayer.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.*
import com.coolme.me.square18.uiLayer.theme.InputText
import com.coolme.me.square18.uiLayer.theme.LabelText
import com.coolme.me.square18.uiLayer.theme.outlinedTextFieldColors

@Composable
fun TextFieldSho(
    isError: Boolean = false,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    keyboardActions: KeyboardActions = KeyboardActions(),
                )
{
    OutlinedTextField(
        isError = isError,
        modifier = Modifier.fillMaxWidth(),
        value = value,
        textStyle = InputText,
        singleLine = true,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                style = LabelText,
                )
        },
        colors = outlinedTextFieldColors(),
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                )
        },
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            keyboardType = keyboardType,
            imeAction = imeAction,
                                         ),
        keyboardActions = keyboardActions,
                     )
}