package a2a.logistic.app.presentation.splash

import a2a.logistic.app.A2ALogisticApplication
import a2a.logistic.app.R
import a2a.logistic.app.utils.UserPreferences
import a2a.logistic.app.utils.UserRole
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    onNavigateToLoginScreen: () -> Unit,
    onNavigateToDashboardScreen: () -> Unit,
    onNavigateToOrderScreen: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Image(
        painter = painterResource(id = R.drawable.splash_screen),
        contentDescription = "splash screen",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )

    val userPref = UserPreferences(context)
    val isLoggedIn = userPref.isLoggedIn()

    Log.e("isLoggedIn splash", isLoggedIn.toString())
    var moveTo = ""

    if (!isLoggedIn)
        moveTo = "login"
    else {
        var userType = userPref.getUser()?.result?.user_type
        A2ALogisticApplication.setUserType("pickup_partner")
        userType = A2ALogisticApplication.getUserType()

        when (userType) {
            UserRole.PICKUP_PARTNER.name,
            UserRole.DELIVERY_PARTNER.name ->
                moveTo = "dashboard"

            UserRole.PICKUP_BOY.name,
            UserRole.VENDOR.name,
            UserRole.DELIVERY_BOY.name,
            UserRole.CARGO_PARTNER.name,
            UserRole.LP_HEAD.name,
            UserRole.LP_MANAGER.name,
            ->
                moveTo = "order"

            else -> {
                Toast.makeText(
                    context,
                    "Not authorized to use this app",
                    Toast.LENGTH_SHORT
                ).show()

                //if user is not authorized then move user to login screen
                onNavigateToLoginScreen()
            }
        }
    }

    LaunchedEffect(key1 = true) {
        scope.launch(Dispatchers.Main) {
            delay(3000)
            when (moveTo) {
                "login" -> onNavigateToLoginScreen()
                "dashboard" -> onNavigateToDashboardScreen()
                "order" -> onNavigateToOrderScreen()
            }
        }
    }
}