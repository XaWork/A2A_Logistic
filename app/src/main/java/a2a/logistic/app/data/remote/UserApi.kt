package a2a.logistic.app.data.remote

import a2a.logistic.app.domain.model.usermodel.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface UserApi {

    @FormUrlEncoded
    @POST("logistic-login")
    suspend fun getOtp(
        @Field("mobile") mobile: String
    ): GetOtpModel

    @FormUrlEncoded
    @POST("verify-logistic")
    suspend fun verifyOtp(
        @Field("mobile") mobile: String,
        @Field("otp") otp: String,
        // @Field("token1") token: String,
    ): VerifyOtpModel

    @FormUrlEncoded
    @POST("add-logistics-boy")
    suspend fun addLogisticsBoy(
        @Field("full_name") fullName: String,
        @Field("mobile") mobile: String,
        @Field("master") master: String,
        @Field("user_type") usertype: String,
        @Field("email") email: String = "",
    ): AddLogisticsBoyResponse

    @FormUrlEncoded
    @POST("list-logistic-boy")
    suspend fun logisticBoyList(
        @Field("master") master: String,
        @Field("user_type") userType: String
    ): UsersListResponse
}

interface UploadImageApi {

    @Multipart
    @POST("update-profile-image-2")
    suspend fun uploadProfileImage(
        @Query("id") id: String,
        @Part upload: MultipartBody.Part
    ): UserDetailResponse

    @Multipart
    @POST("upload_doc1")
    suspend fun uploadAadharCard(
        @Query("id") id: String,
        @Query("doc1_type") docType: String,
        @Part upload: MultipartBody.Part
    ): UserDetailResponse

    @Multipart
    @POST("upload_doc2")
    suspend fun uploadPanCard(
        @Query("id") id: String,
        @Query("doc2_type") docType: String,
        @Part upload: MultipartBody.Part
    ): UserDetailResponse

    @Multipart
    @POST("upload_doc3")
    suspend fun uploadVoterIdCard(
        @Query("id") id: String,
        @Query("doc3_type") docType: String,
        @Part upload: MultipartBody.Part
    ): UserDetailResponse

}