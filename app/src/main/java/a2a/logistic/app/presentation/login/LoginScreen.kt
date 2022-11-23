package a2a.logistic.app.presentation.login

import a2a.logistic.app.R
import a2a.logistic.app.presentation.components.A2ALogisticButton
import a2a.logistic.app.presentation.components.A2ALogisticTextField
import a2a.logistic.app.ui.theme.ScreenPadding
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val mobile = viewModel.mobile
    val gotOtp = viewModel.gotOTP
    val otp = viewModel.gotOTP

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(all = ScreenPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_1024x1024),
                contentDescription = "",
                modifier = Modifier.size(160.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))

            A2ALogisticTextField(
                value = (if (gotOtp) otp else mobile).toString(),
                onValueChange = {
                    if (gotOtp)
                        viewModel.updateOtp(it)
                    else
                        viewModel.updateMobile(it)
                },
                label = if (gotOtp) "OTP" else "Mobile",
                leadingIcon = if (gotOtp) R.drawable.password else R.drawable.mobile
            )

            Text(text = if (gotOtp) "Edit Mobile" else "", modifier = Modifier.align(Alignment.End))

            Spacer(modifier = Modifier.height(30.dp))

            A2ALogisticButton(
                modifier = Modifier.fillMaxWidth(),
                title = if (gotOtp) "Login" else "Generate Otp",
                textAllCaps = true
            ) {

            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}