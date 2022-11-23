package a2a.logistic.app.domain.repository

import a2a.logistic.app.domain.model.GetOtpModel
import a2a.logistic.app.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun getOtp(mobile: String): Flow<Resource<GetOtpModel>>
}