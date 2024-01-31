package com.example.mvvmlogin.ui.theme.login.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.mvvmlogin.R

@Composable
fun LoginButton(
    loginEnable: Boolean,
    onLoginSelected: () -> Unit
) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(colorResource(R.color.pink_general),
            disabledContainerColor = colorResource(R.color.pink_general_gradle),
            disabledContentColor = colorResource(R.color.white)
        ),
        enabled = loginEnable
    ) {
        Text(
            text = "Iniciar sesion")
    }
}
