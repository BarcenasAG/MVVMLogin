package com.example.mvvmlogin.ui.theme.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvmlogin.ui.theme.login.ui.composables.EmailField
import com.example.mvvmlogin.ui.theme.login.ui.composables.ForgotPassword
import com.example.mvvmlogin.ui.theme.login.ui.composables.HeaderImage
import com.example.mvvmlogin.ui.theme.login.ui.composables.LoginButton
import com.example.mvvmlogin.ui.theme.login.ui.composables.LoginDivider
import com.example.mvvmlogin.ui.theme.login.ui.composables.PasswordField
import com.example.mvvmlogin.ui.theme.login.ui.composables.SignUp
import com.example.mvvmlogin.ui.theme.login.ui.composables.SocialLogin
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Login(
            Modifier
                .align(Alignment.Center),
            viewModel)
        Footer(
            Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Login(
    modifier: Modifier,
    viewModel: LoginViewModel
) {

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
    } else {
        Column(
            modifier = modifier
        ) {
            HeaderImage(Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier
                .padding(16.dp)
            )
            EmailField(
                email
            ) {
                viewModel.onLoginChange(email = it,password = password)
            }
            Spacer(
                modifier = Modifier
                    .padding(4.dp)
            )
            PasswordField(
                password
            ) {
                viewModel.onLoginChange(password = it, email = email)
            }
            Spacer(
                modifier = Modifier
                    .padding(8.dp)
            )
            ForgotPassword(
                Modifier
                    .align(Alignment.End)
            )
            Spacer(
                modifier = Modifier
                    .padding(16.dp)
            )
            LoginButton(
                loginEnable
            ) {
                coroutineScope.launch {
                    viewModel.onLoginSelected()
                }
            }
            Spacer(
                modifier = Modifier
                    .padding(16.dp)
            )
            LoginDivider()
            Spacer(
                modifier = Modifier
                    .padding(32.dp)
            )
            SocialLogin()
        }
    }
}

@Composable
fun Footer(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Divider(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .size(24.dp)
        )
        SignUp()
        Spacer(
            modifier = Modifier
                .size(24.dp)
        )
    }
}
