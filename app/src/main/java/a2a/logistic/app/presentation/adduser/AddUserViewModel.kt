package a2a.logistic.app.presentation.adduser

import a2a.logistic.app.domain.repository.AddUserRepository
import a2a.logistic.app.utils.Resource
import a2a.logistic.app.utils.UserPreferences
import android.R.attr.data
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject


@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val repository: AddUserRepository,
    val userPreferences: UserPreferences
) : ViewModel() {

    var state by mutableStateOf(AddUserState())

    fun onEvent(event: AddUserEvents) {
        when (event) {
            is AddUserEvents.AddUser -> {
                addUser(
                    fullName = event.fullName,
                    mobile = event.mobile,
                    master = event.master,
                    usertype = event.usertype,
                    email = event.email
                )
            }
            is AddUserEvents.UploadProfileImage -> {
                uploadProfileImage(
                    userId = event.userId,
                    uri = event.uri
                )
            }
            is AddUserEvents.UploadAadharCard -> {
                uploadAadharCard(
                    userId = event.userId,
                    uri = event.uri
                )
            }
            is AddUserEvents.UploadPanCard -> {
                uploadPanCard(
                    userId = event.userId,
                    uri = event.uri
                )
            }
            is AddUserEvents.UploadVoterIdCard -> {
                uploadVoterIdCard(
                    userId = event.userId,
                    uri = event.uri
                )
            }
        }
    }

    private fun addUser(
        fullName: String,
        mobile: String,
        master: String,
        usertype: String,
        email: String = "",
    ) {
        viewModelScope.launch {
            repository
                .addLogisticBoy(
                    fullName = fullName,
                    mobile = mobile,
                    master = master,
                    usertype = usertype,
                    email = email
                ).collect { result ->
                    state = when (result) {
                        is Resource.Loading -> state.copy(isLoading = true)
                        is Resource.Success -> state.copy(
                            addLogisticsBoyResponse = result.data,
                            isLoading = false,
                        )
                        is Resource.Error -> state.copy(
                            error = result.message,
                            isLoading = false,
                            addLogisticsBoyResponse = null
                        )
                    }
                }
        }
    }

    private fun uploadProfileImage(userId: String, uri: Uri) {
        val file = File(uri.path!!)
        val requestFile = uri.path!!.toRequestBody("multipart/form-data".toMediaTypeOrNull())
        val multipartBody = MultipartBody.Part.createFormData("file", file.name, requestFile)

        viewModelScope.launch {
            repository
                .uploadProfileImage(
                    id = userId,
                    upload = multipartBody
                ).collect { result ->
                    state = when (result) {
                        is Resource.Loading -> state.copy(isLoading = true)
                        is Resource.Success -> state.copy(
                            userDetailResponse = result.data,
                            isLoading = false,
                        )
                        is Resource.Error -> state.copy(
                            error = result.message,
                            isLoading = false,
                            userDetailResponse = null
                        )
                    }
                }
        }
    }

    private fun uploadAadharCard(userId: String, uri: Uri) {
        val file = File(uri.path!!)
        val requestFile = uri.path!!.toRequestBody("multipart/form-data".toMediaTypeOrNull())
        val multipartBody = MultipartBody.Part.createFormData("file", file.name, requestFile)

        viewModelScope.launch {
            repository
                .uploadAadharCard(
                    id = userId,
                    upload = multipartBody,
                    docType = "Aadhar Card"
                ).collect { result ->
                    state = when (result) {
                        is Resource.Loading -> state.copy(isLoading = true)
                        is Resource.Success -> state.copy(
                            userDetailResponse = result.data,
                            isLoading = false,
                        )
                        is Resource.Error -> state.copy(
                            error = result.message,
                            isLoading = false,
                            userDetailResponse = null
                        )
                    }
                }
        }
    }

    private fun uploadPanCard(userId: String, uri: Uri) {
        val file = File(uri.path!!)
        val requestFile = uri.path!!.toRequestBody("multipart/form-data".toMediaTypeOrNull())
        val multipartBody = MultipartBody.Part.createFormData("file", file.name, requestFile)

        viewModelScope.launch {
            repository
                .uploadPanCard(
                    id = userId,
                    upload = multipartBody,
                    docType = "Pan Card"
                ).collect { result ->
                    state = when (result) {
                        is Resource.Loading -> state.copy(isLoading = true)
                        is Resource.Success -> state.copy(
                            userDetailResponse = result.data,
                            isLoading = false,
                        )
                        is Resource.Error -> state.copy(
                            error = result.message,
                            isLoading = false,
                            userDetailResponse = null
                        )
                    }
                }
        }
    }

    private fun uploadVoterIdCard(userId: String, uri: Uri) {
        val file = File(uri.path!!)
        val requestFile = uri.path!!.toRequestBody("multipart/form-data".toMediaTypeOrNull())
        val multipartBody = MultipartBody.Part.createFormData("file", file.name, requestFile)

        viewModelScope.launch {
            repository
                .uploadVoterIdCard(
                    id = userId,
                    upload = multipartBody,
                    docType = "Voter Card"
                ).collect { result ->
                    state = when (result) {
                        is Resource.Loading -> state.copy(isLoading = true)
                        is Resource.Success -> state.copy(
                            userDetailResponse = result.data,
                            isLoading = false,
                        )
                        is Resource.Error -> state.copy(
                            error = result.message,
                            isLoading = false,
                            userDetailResponse = null
                        )
                    }
                }
        }
    }
}