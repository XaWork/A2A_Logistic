package a2a.logistic.app.domain.repository

import a2a.logistic.app.domain.model.usermodel.GetOtpModel
import a2a.logistic.app.domain.model.usermodel.VerifyOtpModel
import a2a.logistic.app.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun getOtp(mobile: String): Flow<Resource<GetOtpModel>>

    suspend fun verifyOtp(mobile: String, otp: String): Flow<Resource<VerifyOtpModel>>
}