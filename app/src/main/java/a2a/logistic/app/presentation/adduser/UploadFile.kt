package a2a.logistic.app.presentation.adduser

import a2a.logistic.app.R
import a2a.logistic.app.presentation.components.A2ALogisticButton
import a2a.logistic.app.presentation.utils.uriToBitmap
import a2a.logistic.app.presentation.utils.uriToFile
import a2a.logistic.app.presentation.ui.theme.ScreenPadding
import a2a.logistic.app.presentation.ui.theme.SpaceBetweenViewsAndSubViews
import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import java.io.File

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun UploadFile(
    context: Context,
    title: String,
    bitmapImage: Bitmap?,
    onBitmapImageChange: (Uri) -> Unit,
    onUpload: () -> Unit,
) {
    val permissionState = rememberMultiplePermissionsState(
        permissions =
        listOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            Log.e("Uplaod file", "$it")
            try{
                onBitmapImageChange(it!!)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    )

    Column(
        modifier = Modifier
            .padding(vertical = SpaceBetweenViewsAndSubViews)
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (bitmapImage != null) {
            Image(
                bitmap = bitmapImage.asImageBitmap(),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .padding(ScreenPadding)
                    .clickable {
                        if (permissionState.allPermissionsGranted)
                            launcher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        else {
                            Toast
                                .makeText(
                                    context,
                                    "Please allow the permission to pick image from gallery.",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                            permissionState.launchMultiplePermissionRequest()
                        }
                    }
            )
        } else
            Image(
                painter = painterResource(id = R.drawable.ic_create_new_folder_black_24dp),
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                modifier = Modifier
                    .size(150.dp)
                    .padding(ScreenPadding)
                    .clickable {
                        if (permissionState.allPermissionsGranted)
                            launcher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        else
                            permissionState.launchMultiplePermissionRequest()
                    }
            )

        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )

        Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

        A2ALogisticButton(
            title = "Upload",
            textAllCaps = true,
            onClick = onUpload
        )
    }
}

@Preview
@Composable
fun SingleUploadFilePreview() {
    /* UploadFile(item = UploadFileItem("Upload Profile")) {

     }*/
}

data class UploadFileItem(
    val title: String,
)

val uploadItemList = listOf(
    UploadFileItem("Profile Image"),
    UploadFileItem("Voter Card"),
    UploadFileItem("Aadhar Card"),
    UploadFileItem("PAN Card")
)