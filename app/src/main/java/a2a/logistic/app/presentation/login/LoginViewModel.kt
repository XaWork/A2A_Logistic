package a2a.logistic.app.presentation.login

import a2a.logistic.app.domain.repository.LoginRepository
import a2a.logistic.app.utils.Resource
import a2a.logistic.app.utils.UserPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    val userPreferences: UserPreferences
) : ViewModel() {

    var state by mutableStateOf(LoginState())

    fun onEvent(events: LoginEvents) {
        when (events) {
            is LoginEvents.GetOtp -> {
                getOtp(events.mobile)
            }
            is LoginEvents.VerifyOtp -> {
                verifyOtp(
                    mobile = events.mobile,
                    otp = events.otp
                )
            }
            is LoginEvents.ReenterMobile -> {
                state = state.copy(gotOtp = false)
            }
        }
    }

    private fun getOtp(mobile: String) {
        viewModelScope.launch {
            repository
                .getOtp(mobile = mobile)
                .collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            state = state.copy(
                                isLoading = false,
                                error = result.message,
                                getOtpModel = null
                            )
                        }
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                        is Resource.Success -> {
                            result.data?.let {
                                state =
                                    state.copy(getOtpModel = it, gotOtp = true, isLoading = false)
                            }
                        }
                    }
                }
        }
    }

    private fun verifyOtp(mobile: String, otp: String) {
        viewModelScope.launch {
            repository
                .verifyOtp(
                    mobile = mobile,
                    otp = otp
                )
                .collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            state = state.copy(
                                isLoading = false,
                                error = result.message,
                                verifyOtpModel = null
                            )
                        }
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                        is Resource.Success -> {
                            result.data?.let {
                                state = state.copy(
                                    verifyOtpModel = it,
                                    gotOtp = true,
                                    isLoading = false
                                )
                            }
                        }
                    }
                }
        }
    }
}