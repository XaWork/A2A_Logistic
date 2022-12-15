package a2a.logistic.app.domain.repository

import a2a.logistic.app.domain.model.usermodel.AddLogisticsBoyResponse
import a2a.logistic.app.domain.model.usermodel.UserDetailResponse
import a2a.logistic.app.utils.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface AddUserRepository {

    suspend fun addLogisticBoy(
        fullName: String,
        mobile: String,
        master: String,
        usertype: String,
        email: String,
    ): Flow<Resource<AddLogisticsBoyResponse>>

    suspend fun uploadProfileImage(
        id: String,
        upload: MultipartBody.Part
    ): Flow<Resource<UserDetailResponse>>

    suspend fun uploadAadharCard(
        id: String,
        docType: String,
        upload: MultipartBody.Part
    ): Flow<Resource<UserDetailResponse>>

    suspend fun uploadPanCard(
        id: String,
        docType: String,
        upload: MultipartBody.Part
    ): Flow<Resource<UserDetailResponse>>

    suspend fun uploadVoterIdCard(
        id: String,
        docType: String,
        upload: MultipartBody.Part
    ): Flow<Resource<UserDetailResponse>>
}