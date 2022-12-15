package a2a.logistic.app.presentation.login

sealed class LoginEvents {
    data class GetOtp(val mobile: String) : LoginEvents()
    data class VerifyOtp(val mobile: String, val otp: String) : LoginEvents()
    object ReenterMobile : LoginEvents()
}
