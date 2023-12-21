package com.example.mvvmlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvmlogin.ui.theme.login.ui.LoginScreen
import com.example.mvvmlogin.ui.theme.login.ui.LoginViewModel
import com.example.mvvmlogin.ui.theme.theme.MVVMLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMLoginTheme {
                Surface(modifier = Modifier
                    .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(LoginViewModel())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMLoginTheme {
        LoginScreen(LoginViewModel())
    }
}
