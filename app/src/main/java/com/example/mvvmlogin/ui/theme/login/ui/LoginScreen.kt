package com.example.mvvmlogin.ui.theme.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvmlogin.ui.theme.login.composables.EmailField
import com.example.mvvmlogin.ui.theme.login.composables.ForgotPassword
import com.example.mvvmlogin.ui.theme.login.composables.HeaderImage
import com.example.mvvmlogin.ui.theme.login.composables.LoginButton
import com.example.mvvmlogin.ui.theme.login.composables.PasswordField
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
