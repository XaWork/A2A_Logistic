package a2a.logistic.app.data.repository

import a2a.logistic.app.data.remote.UserApi
import a2a.logistic.app.domain.model.usermodel.ChangeUserStatusResponse
import a2a.logistic.app.domain.model.usermodel.UsersListResponse
import a2a.logistic.app.domain.repository.ManageUserRepository
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

    override suspend fun employeeStatusChange(id: String): ChangeUserStatusResponse {
        return api.employeeStatusChange(id)
    }
}