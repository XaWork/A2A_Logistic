package a2a.logistic.app.presentation.dashboard

import a2a.logistic.app.A2ALogisticApplication
import a2a.logistic.app.presentation.components.A2AMainTopAppBar
import a2a.logistic.app.presentation.ui.theme.ScreenPadding
import a2a.logistic.app.utils.UserPreferences
import a2a.logistic.app.utils.UserRole
import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(
    onNavigateToAddUserScreen: () -> Unit,
    onNavigateToLoginScreen: () -> Unit,
    onNavigateToMyUserListScreen: () -> Unit,
    onNavigateToMyOrderListScreen: () -> Unit,
    onNavigateToFinancialLogScreen: () -> Unit,
) {
    var showDialog by remember { mutableStateOf(false) }
    val context: Context = LocalContext.current

    if (showDialog)
        LogoutDialog(
            showDialog = { showDialog = it },
            onConfirm = {
                logOutUser(
                    context = context,
                    onNavigateToLoginScreen = onNavigateToLoginScreen
                )
            }
        )

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        topBar = {
            A2AMainTopAppBar(onLogOutClick = {
                showDialog = true
            })
        },
        content = { padding ->
            val value = padding

            val userType = A2ALogisticApplication.getUserType()
            if (userType.contentEquals(UserRole.DELIVERY_PARTNER.name)) {
                dashboardItemList.removeAt(2)
                dashboardItemList.removeAt(3)
            }

            ContentDashboard(
                dashboardItems = dashboardItemList,
                onDashboardItemClick = { dashboardItem ->
                    when (dashboardItem.id) {
                        "Add Delivery Boy" -> {
                            onNavigateToAddUserScreen()
                        }
                        "Manage Delivery Boy" -> {
                            onNavigateToMyUserListScreen()
                        }
                        "Add Pickup Boy" -> {
                            onNavigateToAddUserScreen()
                        }
                        "Manage Pickup Boy" -> {
                            onNavigateToMyUserListScreen()
                        }
                        "View Assigned Orders" -> {
                            onNavigateToMyOrderListScreen()
                        }
                        "Assign Orders" -> {
                            onNavigateToMyOrderListScreen()
                        }
                        "Financial Logs" -> {
                            onNavigateToFinancialLogScreen()
                        }
                        "Reports" -> {}
                    }
                }
            )
        }
    )
}

@Composable
fun ContentDashboard(
    dashboardItems: List<DashboardItem>,
    onDashboardItemClick: (DashboardItem) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(ScreenPadding)
            .clip(RoundedCornerShape(10.dp)),
        columns = GridCells.Fixed(2),
    ) {
        items(dashboardItems) { item ->
            SingleDashboardItem(item = item, onItemClick = { dashboardItem ->
                onDashboardItemClick(dashboardItem)
            })
        }
    }
}

fun logOutUser(context: Context, onNavigateToLoginScreen: () -> Unit) {
    val userPref = UserPreferences(context)
    userPref.logOut { onNavigateToLoginScreen() }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    //DashboardScreen({}, {})
}