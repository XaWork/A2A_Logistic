package a2a.logistic.app.data.remote

import a2a.logistic.app.domain.model.GetOtpModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {

    @FormUrlEncoded
    @POST
    suspend fun getOtp(
        @Field("mobile") mobile: String
    ): GetOtpModel
}