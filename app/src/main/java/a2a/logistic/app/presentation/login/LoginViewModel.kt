package a2a.logistic.app.presentation.login

import a2a.logistic.app.domain.repository.LoginRepository
import a2a.logistic.app.utils.Resource
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
    private val repository: LoginRepository
) : ViewModel() {

    var mobile by mutableStateOf("")
    var gotOTP by mutableStateOf(false)
    var otp by mutableStateOf("false")

    fun updateMobile(update: String) {
        mobile = update
    }

    fun updateOtp(update: String) {
        otp = update
    }

    var state by mutableStateOf(LoginState())

    fun onEvent(events: LoginEvents) {
        when (events) {
            is LoginEvents.GetOtp -> {
                getOtp(events.mobile)
            }
            is LoginEvents.VerifyOtp -> {

            }
            is LoginEvents.ReEnterMobile -> {

            }
        }
    }

    fun getOtp(mobile: String) {
        viewModelScope.launch {
            repository
                .getOtp(mobile = mobile)
                .collect { result ->
                    when (result) {
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                        is Resource.Success -> {
                            result.data?.let {
                                state = state.copy(getOtpModel = it, gotOtp = true)
                            }
                        }
                    }
                }
        }
    }
}