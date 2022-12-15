package a2a.logistic.app.presentation.adduser

import android.net.Uri
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

sealed class AddUserEvents {
    data class AddUser(
        val fullName: String,
        val mobile: String,
        val master: String,
        val usertype: String,
        val email: String = "",
    ) : AddUserEvents()

    data class UploadProfileImage(
        val userId : String,
        val uri: Uri
    ): AddUserEvents()

    data class UploadAadharCard(
        val userId : String,
        val uri: Uri
    ): AddUserEvents()

    data class UploadPanCard(
        val userId : String,
        val uri: Uri
    ): AddUserEvents()

    data class UploadVoterIdCard(
        val userId : String,
        val uri: Uri
    ): AddUserEvents()
}
