package com.example.mvvmlogin.ui.theme.login.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvmlogin.R

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo_shugar_pink),
        contentDescription = "Header",
        modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun HeaderImagePreview() {
    HeaderImage(Modifier)
}
