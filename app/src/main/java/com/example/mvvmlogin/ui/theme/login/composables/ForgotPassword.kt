package com.example.mvvmlogin.ui.theme.login.composables

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mvvmlogin.R

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(text = "Olvidaste la contraseña?",
        modifier = modifier
            .clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.pink_general))
}

@Preview
@Composable
fun ForgotPasswordPreview(){
}
