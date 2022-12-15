package a2a.logistic.app.presentation.login

import a2a.logistic.app.A2ALogisticApplication
import a2a.logistic.app.R
import a2a.logistic.app.presentation.components.A2ALogisticButton
import a2a.logistic.app.presentation.components.A2ALogisticTextField
import a2a.logistic.app.presentation.components.BackHandler
import a2a.logistic.app.presentation.ui.theme.ScreenPadding
import a2a.logistic.app.utils.UserPreferences
import a2a.logistic.app.utils.UserRole
import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(
    onNavigateToDashboardScreen: () -> Unit,
    onNavigateToOrderScreen: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
) {

    val context: Context = LocalContext.current
    val activity = context as? Activity
    val userPreferences = viewModel.userPreferences
    rememberCoroutineScope()

    val state = viewModel.state
    val gotOtp = state.gotOtp

    Log.e("login", "Got otp $gotOtp")

    val mobileMaxLength = 10
    val otpMaxLength = 6

    var mobile by remember {
        mutableStateOf("")
    }
    var otp by remember {
        mutableStateOf("")
    }
    val label by remember(gotOtp) {
        mutableStateOf(
            if (!gotOtp) "Mobile" else "OTP"
        )
    }
    val leadingIcon by remember(gotOtp) {
        mutableStateOf(
            if (!gotOtp) R.drawable.mobile else R.drawable.password
        )
    }
    val buttonText by remember(gotOtp) {
        mutableStateOf(
            if (!gotOtp) "Generate OTP" else "Login"
        )
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(all = ScreenPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_1024x1024),
                contentDescription = "",
                modifier = Modifier
                    .height(160.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))

            A2ALogisticTextField(
                value = if (!gotOtp) mobile else otp,
                onValueChange = {
                    if (!gotOtp) {
                        if (it.length <= mobileMaxLength) mobile = it
                    } else
                        if (it.length <= otpMaxLength) otp = it
                },
                label = label,
                leadingIcon = leadingIcon,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            Spacer(modifier = Modifier.height(30.dp))

            A2ALogisticButton(
                modifier = Modifier.fillMaxWidth(),
                title = buttonText,
                textAllCaps = true
            ) {
                if (gotOtp) {
                    if (otp.length < otpMaxLength)
                        Toast.makeText(context, "Enter valid OTP", Toast.LENGTH_SHORT).show()
                    else
                        viewModel.onEvent(LoginEvents.VerifyOtp(mobile, otp))
                } else {
                    if (mobile.length < mobileMaxLength)
                        Toast.makeText(context, "Enter valid mobile", Toast.LENGTH_SHORT).show()
                    else
                        viewModel.onEvent(LoginEvents.GetOtp(mobile))
                }
            }

            //when data is loading or getting error
            if (state.isLoading)
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            else if (state.error != null)
                Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
            else if (state.verifyOtpModel != null) {
                LaunchedEffect(key1 = true) {
                    moveToNext(
                        userPreferences = userPreferences,
                        viewModel = viewModel,
                        context = context,
                        onNavigateToOrderScreen = onNavigateToOrderScreen,
                        onNavigateToDashboardScreen = onNavigateToDashboardScreen
                    )
                }
            }
        }

    }

    //Handle back press
    BackHandler(enabled = true) {
        if (gotOtp)
            viewModel.onEvent(LoginEvents.ReenterMobile)
        else
            activity?.finish()
    }
}

fun moveToNext(
    userPreferences: UserPreferences,
    viewModel: LoginViewModel,
    onNavigateToDashboardScreen: () -> Unit,
    onNavigateToOrderScreen: () -> Unit,
    context: Context
) {
    val state = viewModel.state

    //save user
    userPreferences.saveUser(state.verifyOtpModel!!)
    userPreferences.setLoggedIn(isLoggedIn = true)

    var userType = userPreferences.getUser()?.result?.user_type
    A2ALogisticApplication.setUserType("pickup_partner")
    userType = A2ALogisticApplication.getUserType()

    when (userType) {
        UserRole.PICKUP_PARTNER.name,
        UserRole.DELIVERY_PARTNER.name ->
            onNavigateToDashboardScreen()

        UserRole.PICKUP_BOY.name,
        UserRole.VENDOR.name,
        UserRole.DELIVERY_BOY.name,
        UserRole.CARGO_PARTNER.name,
        UserRole.LP_HEAD.name,
        UserRole.LP_MANAGER.name,
        ->
            onNavigateToOrderScreen()

        else ->
            Toast.makeText(
                context,
                "Not authorized to use this app",
                Toast.LENGTH_SHORT
            ).show()
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
     LoginScreen({}, {})
}