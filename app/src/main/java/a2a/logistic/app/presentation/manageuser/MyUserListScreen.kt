package a2a.logistic.app.presentation.manageuser

import a2a.logistic.app.R
import a2a.logistic.app.presentation.components.A2ALogisticTopAppBar
import a2a.logistic.app.presentation.ui.theme.*
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MyUserListScreen(
    onBackPress: () -> Unit,
    onNavigateToUserDetailsScreen: () -> Unit,
    viewModel: ManageUserViewModel = hiltViewModel()
) {
    val state = viewModel.state
    viewModel.onEvent(ManageUserEvents.LogisticBoyList)

    Scaffold(
        topBar = {
            A2ALogisticTopAppBar(
                title = "Users",
                onBackPress = onBackPress
            )
        },
        content = {
            val value = it
            //UserList(onItemClick = onNavigateToUserDetailsScreen)

            if (state.value.isLoading)
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            else if (state.value.error != null) {
                Toast.makeText(LocalContext.current, state.value.error, Toast.LENGTH_SHORT).show()
                onBackPress()
            } else if (state.value.usersListResponse != null)
                UserList(onItemClick = onNavigateToUserDetailsScreen)
            else
                UserList(onItemClick = onNavigateToUserDetailsScreen)
        }
    )
}

@Composable
fun UserList(onItemClick: () -> Unit) {
    LazyColumn(modifier = Modifier.padding(ScreenPadding)) {
        items(10) {
            SingleUserItem(onItemClick = onItemClick)
        }
    }
}

@Composable
fun SingleUserItem(
    onItemClick: () -> Unit
) {
    var userStatus by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(vertical = SpaceBetweenViewsAndSubViews)
            .fillMaxWidth()
            .clickable { onItemClick() },
        elevation = CardElevation,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Row(
            modifier = Modifier.padding(LowPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("")
                    .placeholder(R.drawable.image_placeholder)
                    .error(R.drawable.image_placeholder)
                    .transformations()
                    .build(),
                contentDescription = "",
                modifier = Modifier
                    .weight(1f)
                    .size(80.dp)
            )

            Spacer(modifier = Modifier.width(SpaceBetweenViews))

            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "User name",
                    fontSize = 16.sp,
                    color = Color.White
                )

                Text(
                    text = "9910508758",
                    fontSize = 14.sp,
                    color = Color.White
                )

                Text(
                    text = "DCEP",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }

            Switch(
                checked = userStatus,
                onCheckedChange = { userStatus = it },
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview
@Composable
fun MyUserListScreenPreview() {

}