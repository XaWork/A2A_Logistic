package a2a.logistic.app.domain.use_case.manage_user

import a2a.logistic.app.domain.model.usermodel.UsersListResponse
import a2a.logistic.app.domain.repository.ManageUserRepository
import a2a.logistic.app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LogisticBoyListUseCase @Inject constructor(
    private val repository: ManageUserRepository
) {

    operator fun invoke(
        master: String,
        userType: String
    ): Flow<Resource<UsersListResponse>> = flow {
        emit(Resource.Loading(true))
        try {
            val response = repository.logisticBoyList(
                master = master,
                userType = userType
            )

            if (response.message == "success")
                emit(Resource.Success(data = response))
            else
                emit(Resource.Error(message = response.message))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(message = "Couldn't Load data"))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(message = "Couldn't Load data"))
        }
    }
}