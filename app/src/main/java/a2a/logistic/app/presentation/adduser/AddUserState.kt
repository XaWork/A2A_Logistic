package a2a.logistic.app.presentation.adduser

import a2a.logistic.app.domain.model.usermodel.AddLogisticsBoyResponse
import a2a.logistic.app.domain.model.usermodel.UserDetailResponse
import a2a.logistic.app.utils.Resource

data class AddUserState(
    val addLogisticsBoyResponse: AddLogisticsBoyResponse? = null,
    val userDetailResponse: UserDetailResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
