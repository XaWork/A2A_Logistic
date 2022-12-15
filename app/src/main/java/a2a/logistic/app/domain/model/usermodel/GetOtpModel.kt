package a2a.logistic.app.domain.model.usermodel

data class GetOtpModel(
    val OTP: Int,
    val message: String,
    val status: String
)