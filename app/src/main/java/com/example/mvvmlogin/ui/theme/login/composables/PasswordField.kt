package com.example.mvvmlogin.ui.theme.login.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvmlogin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {

    TextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        placeholder = {
            Text(text = "Password")
        },
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = (
            KeyboardOptions(keyboardType = KeyboardType.Password)),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(R.color.pink_general),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent)
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordFieldPreview(){
}
