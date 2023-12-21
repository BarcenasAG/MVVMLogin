package com.example.mvvmlogin.ui.theme.login.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmlogin.R
import com.example.mvvmlogin.ui.theme.login.composables.HeaderImage
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Box(Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Login(Modifier
            .align(Alignment.Center),
            viewModel)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel) {

    val email: String by viewModel.email.observeAsState(initial = "")

    val password: String by viewModel.password.observeAsState(initial = "")

    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)

    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)

    val coroutineScope = rememberCoroutineScope()

    if (isLoading) {
        Box(
            Modifier
                .fillMaxSize()
        ) {
            CircularProgressIndicator(
                Modifier
                    .align(Alignment.Center)
            )
        }
    }else{
        Column(
            modifier = modifier
        ) {
            HeaderImage(Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier
                .padding(16.dp)
            )
            EmailField(email) { viewModel.onLoginChange(it, password)
            }
            Spacer(modifier = Modifier
                .padding(4.dp)
            )
            PasswordField(password) { viewModel.onLoginChange(email, it)
            }
            Spacer(modifier = Modifier
                .padding(8.dp)
            )
            ForgotPassword(Modifier
                .align(Alignment.End)
            )
            Spacer(modifier = Modifier
                .padding(16.dp)
            )
            LoginButton(loginEnable) {
                coroutineScope.launch {
                    viewModel.onLoginSelected()
                }
            }
        }
    }
}

@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(colorResource(R.color.pink_general),
            disabledContainerColor = colorResource(R.color.pink_general_gradle),
            contentColor = colorResource(R.color.white),
            disabledContentColor = colorResource(R.color.white)
        ),
        enabled = loginEnable
    ) {
        Text(text = "Iniciar sesion")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(text = "Olvidaste la contraseña?",
        modifier = modifier
            .clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.pink_general))
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {

    TextField(value = email,
        onValueChange = { onTextFieldChanged(it) },
        placeholder = {
            Text(text = "Email")
        },
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = (
            KeyboardOptions(keyboardType = KeyboardType.Email)
            ),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(R.color.pink_general),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent)
    )
}

