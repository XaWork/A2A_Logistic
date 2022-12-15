package a2a.logistic.app.presentation.manageuser

import a2a.logistic.app.domain.model.usermodel.UsersListResponse

data class ManageUserState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val usersListResponse: UsersListResponse? = null
)
