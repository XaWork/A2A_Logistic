package a2a.logistic.app.data.repository

import a2a.logistic.app.A2ALogisticApplication.Companion.userType
import a2a.logistic.app.data.remote.UserApi
import a2a.logistic.app.domain.model.usermodel.UsersListResponse
import a2a.logistic.app.domain.repository.ManageUserRepository
import a2a.logistic.app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ManageUserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : ManageUserRepository {

    override suspend fun logisticBoyList(
        master: String,
        userType: String
    ): UsersListResponse {
        return api.logisticBoyList(master = master, userType = userType)
    }
}