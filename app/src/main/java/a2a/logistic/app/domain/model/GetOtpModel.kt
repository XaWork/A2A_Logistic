package a2a.logistic.app.domain.model

data class GetOtpModel(
    val OTP: Int,
    val message: String,
    val status: String
)