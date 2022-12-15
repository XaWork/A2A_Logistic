package a2a.logistic.app.presentation.adduser

import a2a.logistic.app.A2ALogisticApplication
import a2a.logistic.app.domain.model.usermodel.AddLogisticsBoyResponse
import a2a.logistic.app.presentation.components.A2ALogisticButton
import a2a.logistic.app.presentation.components.A2ALogisticTextField
import a2a.logistic.app.presentation.components.A2ALogisticTopAppBar
import a2a.logistic.app.presentation.ui.theme.ScreenPadding
import a2a.logistic.app.presentation.ui.theme.SpaceBetweenViews
import a2a.logistic.app.presentation.ui.theme.SpaceBetweenViewsAndSubViews
import a2a.logistic.app.presentation.utils.uriToBitmap
import a2a.logistic.app.utils.UserRole
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import java.io.File

@Composable
fun AddUserScreen(
    onBackPress: () -> Unit,
    onNavigateToUserDetailsScreen: (AddLogisticsBoyResponse) -> Unit,
    viewModel: AddUserViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            A2ALogisticTopAppBar(
                title = if (A2ALogisticApplication.getUserType()
                        .contentEquals(UserRole.DELIVERY_PARTNER.name)
                ) "Add Delivery Boy"
                else "Add Pickup Boy",
                onBackPress = onBackPress
            )
        }, content = {
            val value = it
            Column {
                ContentAddUser(
                    viewModel = viewModel,
                    onAddUser = { user ->
                        viewModel.onEvent(user)
                    },
                    onNavigateToUserDetailsScreen = onNavigateToUserDetailsScreen
                )

                if (viewModel.state.addLogisticsBoyResponse?.status == "success") {

                }

                Text(
                    text = "Document",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(start = ScreenPadding)
                )

                ContentUploadImage(context = context, viewModel = viewModel)
            }
        }
    )
}

@Composable
fun ContentAddUser(
    viewModel: AddUserViewModel,
    onAddUser: (AddUserEvents.AddUser) -> Unit,
    onNavigateToUserDetailsScreen: (AddLogisticsBoyResponse) -> Unit
) {
    val context = LocalContext.current
    val state = viewModel.state
    val userPreferences = viewModel.userPreferences
    val userType = if (A2ALogisticApplication.getUserType()
            .contentEquals(UserRole.PICKUP_PARTNER.name)
    ) "pickup_boy" else "delivery_boy"

    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var mobile by remember {
        mutableStateOf("")
    }
    val maxMobileLength = 10
    var email by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(ScreenPadding)
    ) {
        A2ALogisticTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = "First name",
            leadingIcon = a2a.logistic.app.R.drawable.user,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        A2ALogisticTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = "Last name",
            leadingIcon = a2a.logistic.app.R.drawable.user,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        A2ALogisticTextField(
            value = mobile,
            onValueChange = { if (it.length <= maxMobileLength) mobile = it },
            label = "Mobile number",
            leadingIcon = a2a.logistic.app.R.drawable.mobile,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        A2ALogisticTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            leadingIcon = a2a.logistic.app.R.drawable.email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(SpaceBetweenViews))

        A2ALogisticButton(
            title = "Add",
            textAllCaps = true,
            onClick = {
                onAddUser(
                    AddUserEvents.AddUser(
                        fullName = "$firstName $lastName",
                        mobile = mobile,
                        email = email,
                        master = "6020dad36ee0ec0f8085e353",
                        usertype = userType
                    )
                )
            })

        if (state.isLoading)
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        else if (state.error != null)
            LaunchedEffect(key1 = true) {
                Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
            }
        else if (state.addLogisticsBoyResponse != null)
            LaunchedEffect(true) {
                Toast.makeText(context, "User added successfully.", Toast.LENGTH_SHORT).show()
                //onNavigateToUserDetailsScreen(state.addLogisticsBoyResponse)
            }
    }
}

@Composable
fun ContentUploadImage(
    context: Context,
    viewModel: AddUserViewModel
) {
    var showDialog by remember {
        mutableStateOf(false)
    }

    var profileUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var aadharUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var panCardUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var voterIdUri by remember {
        mutableStateOf<Uri?>(null)
    }

    if (showDialog)
        AddOrEditUserConfirmationDialog(
            showDialog = { showDialog = it },
            onConfirm = { }
        )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(ScreenPadding)
            .verticalScroll(
                rememberScrollState(),
            ),
    ) {
        Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

        UploadFile(
            context = context,
            title = "Profile Image",
            onUpload = {
                profileUri?.let {
                    AddUserEvents.UploadProfileImage(
                        userId =
                        "viewModel.state.addLogisticsBoyResponse!!.result!!.id!!",
                        uri = it
                    )
                }?.let {
                    viewModel.onEvent(
                        it
                    )
                }
            },
            bitmapImage = profileUri?.let { uriToBitmap(context, it) },
            onBitmapImageChange = { uri ->
                profileUri = uri
            }
        )

        UploadFile(
            context = context,
            title = "Voter Card",
            onUpload = {
                voterIdUri?.let {
                    AddUserEvents.UploadVoterIdCard(
                        userId = "",
                        uri = it
                    )
                }?.let {
                    viewModel.onEvent(
                        it
                    )
                }
            },
            bitmapImage = voterIdUri?.let { uriToBitmap(context, it) },
            onBitmapImageChange = { uri ->
                voterIdUri = uri
            }
        )

        UploadFile(
            context = context,
            title = "Aadhar Card",
            onUpload = {
                voterIdUri?.let {
                    AddUserEvents.UploadAadharCard(
                        userId = "",
                        uri = it
                    )
                }?.let {
                    viewModel.onEvent(
                        it
                    )
                }
            },
            bitmapImage = aadharUri?.let { uriToBitmap(context, it) },
            onBitmapImageChange = { uri ->
                aadharUri = uri
            }
        )

        UploadFile(
            context = context,
            title = "Pan Card",
            onUpload = {
                voterIdUri?.let {
                    AddUserEvents.UploadPanCard(
                        userId = "",
                        uri = it
                    )
                }?.let {
                    viewModel.onEvent(
                        it
                    )
                }
            },
            bitmapImage = panCardUri?.let { uriToBitmap(context, it) },
            onBitmapImageChange = { uri ->
                panCardUri = uri
            }
        )

        A2ALogisticButton(
            title = "Submit",
            textAllCaps = true,
        ) {
            showDialog = true
        }

    }
}

@Preview
@Composable
fun AddUserScreenPreview() {
    // AddUserScreen(onBackPress = { /*TODO*/ })

    //ContentUploadImage()
}