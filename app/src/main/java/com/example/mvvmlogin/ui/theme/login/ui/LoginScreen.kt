package com.example.mvvmlogin.ui.theme.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmlogin.R
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
        Footer(
            Modifier
                .align(Alignment.BottomCenter)
        )
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
    } else {
        Column(
            modifier = modifier
        ) {
            HeaderImage(Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier
                .padding(16.dp)
            )
            EmailField(email) {
                viewModel.onLoginChange(it, password)
            }
            Spacer(modifier = Modifier
                .padding(4.dp)
            )
            PasswordField(password) {
                viewModel.onLoginChange(email, it)
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
            Spacer(modifier = Modifier
                .padding(16.dp)
            )
            LoginDivider()
            Spacer(modifier = Modifier
                .padding(32.dp)
            )
            SocialLogin()
        }
    }
}

@Composable
fun Footer(modifier: Modifier) {
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

@Composable
fun SignUp() {
    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Dont have an account?",
            fontSize = 12.sp,
            color = Color(0xFFB5B5B5),
        )
        Text(
            text = "Sign up.",
            Modifier
                .padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.pink_general)
        )
    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_facebook),
            contentDescription = "Social Login FB",
            modifier = Modifier
                .size(16.dp)
        )
        Text(
            text = "Continue as Facebook",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier
                .padding(horizontal = 6.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}
