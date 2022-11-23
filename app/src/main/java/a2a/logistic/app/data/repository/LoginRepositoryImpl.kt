package a2a.logistic.app.data.repository

import a2a.logistic.app.data.remote.UserApi
import a2a.logistic.app.domain.model.GetOtpModel
import a2a.logistic.app.domain.repository.LoginRepository
import a2a.logistic.app.utils.Resource
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@ViewModelScoped
class LoginRepositoryImpl @Inject constructor(
    private val api: UserApi
) : LoginRepository {

    override suspend fun getOtp(mobile: String): Flow<Resource<GetOtpModel>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = api.getOtp(mobile = mobile)
                emit(Resource.Success(response))
            } catch (io: IOException) {
                io.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
            } catch (http: HttpException) {
                http.printStackTrace()
                emit(Resource.Error(message = "Couldn't load data"))
            }
        }
    }
}