package a2a.logistic.app.domain.repository

import a2a.logistic.app.domain.model.usermodel.ChangeUserStatusResponse
import a2a.logistic.app.domain.model.usermodel.UsersListResponse
import kotlinx.coroutines.flow.Flow

interface ManageUserRepository {

    suspend fun logisticBoyList(
        master: String,
        userType: String
    ): UsersListResponse

    suspend fun employeeStatusChange(
        id: String
    ): ChangeUserStatusResponse
}