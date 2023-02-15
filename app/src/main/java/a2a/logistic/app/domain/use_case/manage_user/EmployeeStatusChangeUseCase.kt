package a2a.logistic.app.domain.use_case.manage_user

import a2a.logistic.app.domain.model.usermodel.ChangeUserStatusResponse
import a2a.logistic.app.domain.repository.ManageUserRepository
import a2a.logistic.app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class EmployeeStatusChangeUseCase @Inject constructor(
    private val repository: ManageUserRepository
) {

    operator fun invoke(id: String): Flow<Resource<ChangeUserStatusResponse>> = flow {
        emit(Resource.Loading(true))

        try {
            val response = repository.employeeStatusChange(id)

            if (response.status == "success") {
                emit(Resource.Success(data = response))
            } else {
                emit(Resource.Error(message = response.message))
            }
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(message = "Can't change status right now. Try again later!"))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Resource.Error(message = "Can't change status right now. Try again later!"))
        }
    }
}