package a2a.logistic.app.data.repository

import a2a.logistic.app.data.remote.UploadImageApi
import a2a.logistic.app.data.remote.UserApi
import a2a.logistic.app.domain.model.usermodel.AddLogisticsBoyResponse
import a2a.logistic.app.domain.model.usermodel.UserDetailResponse
import a2a.logistic.app.domain.repository.AddUserRepository
import a2a.logistic.app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AddUserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
    private val uploadImageApi: UploadImageApi
) : AddUserRepository {

    override suspend fun addLogisticBoy(
        fullName: String,
        mobile: String,
        master: String,
        usertype: String,
        email: String
    ): Flow<Resource<AddLogisticsBoyResponse>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = userApi.addLogisticsBoy(
                    fullName = fullName,
                    mobile = mobile,
                    master = master,
                    usertype = usertype,
                    email = email
                )
                if (response.status == "error")
                    emit(Resource.Error(message = response.message))
                else
                    emit(Resource.Success(data = response))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
            }
        }
    }

    override suspend fun uploadProfileImage(
        id: String,
        upload: MultipartBody.Part
    ): Flow<Resource<UserDetailResponse>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = uploadImageApi.uploadProfileImage(id, upload)
                if (response.status == "error")
                    emit(Resource.Error(message = response.message))
                else
                    emit(Resource.Success(data = response))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Check your Internet connection"))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
            }
        }
    }

    override suspend fun uploadAadharCard(
        id: String,
        docType: String,
        upload: MultipartBody.Part
    ): Flow<Resource<UserDetailResponse>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = uploadImageApi.uploadAadharCard(id, docType, upload)
                if (response.status == "error")
                    emit(Resource.Error(message = response.message))
                else
                    emit(Resource.Success(data = response))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Check your Internet connection"))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
            }
        }
    }

    override suspend fun uploadPanCard(
        id: String,
        docType: String,
        upload: MultipartBody.Part
    ): Flow<Resource<UserDetailResponse>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = uploadImageApi.uploadPanCard(id, docType, upload)
                if (response.status == "error")
                    emit(Resource.Error(message = response.message))
                else
                    emit(Resource.Success(data = response))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Check your Internet connection"))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
            }
        }
    }

    override suspend fun uploadVoterIdCard(
        id: String,
        docType: String,
        upload: MultipartBody.Part
    ): Flow<Resource<UserDetailResponse>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = uploadImageApi.uploadVoterIdCard(id, docType, upload)
                if (response.status == "error")
                    emit(Resource.Error(message = response.message))
                else
                    emit(Resource.Success(data = response))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Check your Internet connection"))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
            }
        }
    }
}