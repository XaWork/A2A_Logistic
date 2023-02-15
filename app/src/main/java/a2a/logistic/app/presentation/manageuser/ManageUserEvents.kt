package a2a.logistic.app.presentation.manageuser

import a2a.logistic.app.domain.use_case.manage_user.ManageUserUseCase


sealed class ManageUserEvents {
    object LogisticBoyList : ManageUserEvents()
    data class EmployeeStatusChange(val id: String) : ManageUserEvents()
}