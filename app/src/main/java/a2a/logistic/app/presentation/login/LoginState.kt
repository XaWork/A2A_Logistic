package a2a.logistic.app.presentation.login

import a2a.logistic.app.domain.model.usermodel.GetOtpModel
import a2a.logistic.app.domain.model.usermodel.VerifyOtpModel

data class LoginState(
    val getOtpModel: GetOtpModel? = null,
    val verifyOtpModel: VerifyOtpModel? = null,
    val isLoading: Boolean = false,
    val gotOtp: Boolean = false,
    val error: String? = null
)
