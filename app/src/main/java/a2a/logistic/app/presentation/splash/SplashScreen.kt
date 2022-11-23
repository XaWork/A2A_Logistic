package a2a.logistic.app.presentation.splash

import a2a.logistic.app.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen() {
    Image(
        painter = painterResource(id = R.drawable.splash_screen),
        contentDescription = "splash screen",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}