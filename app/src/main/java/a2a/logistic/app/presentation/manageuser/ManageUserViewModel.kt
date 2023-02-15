package a2a.logistic.app.presentation.manageuser

import a2a.logistic.app.A2ALogisticApplication
import a2a.logistic.app.domain.use_case.manage_user.EmployeeStatusChangeUseCase
import a2a.logistic.app.domain.use_case.manage_user.LogisticBoyListUseCase
import a2a.logistic.app.domain.use_case.manage_user.ManageUserUseCase
import a2a.logistic.app.utils.Constants
import a2a.logistic.app.utils.Constants.DELIVERY_BOY
import a2a.logistic.app.utils.Constants.PICKUP_BOY
import a2a.logistic.app.utils.Resource
import a2a.logistic.app.utils.UserPreferences
import a2a.logistic.app.utils.UserRole
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageUserViewModel @Inject constructor(
    private val manageUserUseCase: ManageUserUseCase,
    private val userPreferences: UserPreferences,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ManageUserState())
    val state = _state

    var lastScreen = ""

    init {
        savedStateHandle.get<String>(Constants.LAST_SCREEN)?.let {
            lastScreen = it
        }
    }

    fun onEvent(event: ManageUserEvents) {
        when (event) {
            is ManageUserEvents.LogisticBoyList -> {
                getLogisticBoyList()
            }
            is ManageUserEvents.EmployeeStatusChange -> {
                employeeStatusChange(event.id)
            }
        }
    }

    private fun getLogisticBoyList() {
        val master = userPreferences.getAccessToken()
        val userType =
            if (A2ALogisticApplication.getUserType()
                    .contentEquals(UserRole.DELIVERY_PARTNER.name)
            ) DELIVERY_BOY
            else PICKUP_BOY

        manageUserUseCase.logisticBoyListUseCase(
            master = master,
            userType = userType
        ).onEach { result ->
            when (result) {
                is Resource.Loading ->
                    _state.value = ManageUserState(isLoading = true)

                is Resource.Error ->
                    _state.value = ManageUserState(isLoading = false, error = result.message)

                is Resource.Success ->
                    _state.value =
                        ManageUserState(isLoading = false, usersListResponse = result.data)
            }
        }.launchIn(viewModelScope)
    }

    private fun employeeStatusChange(id: String) {
        manageUserUseCase.employeeStatusChangeUseCase(id)
            .onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            employeeStatusChange = result.data
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }
}