package a2a.logistic.app.domain.use_case.manage_user

data class ManageUserUseCase(
    val logisticBoyListUseCase: LogisticBoyListUseCase,
    val employeeStatusChangeUseCase: EmployeeStatusChangeUseCase
)
