package a2a.logistic.app.presentation.dashboard

import a2a.logistic.app.R

data class DashboardItem(
    val icon: Int,
    val id: String,
    val title: String,
    val showHorizontalDivider: Boolean,
    val showVerticalDivider: Boolean
)

val dashboardItemList =  mutableListOf(
    DashboardItem(
        id = "Add Delivery Boy",
        icon = R.drawable.category1,
        title = "Add Delivery Boy",
        showHorizontalDivider = true,
        showVerticalDivider = true
    ),
    DashboardItem(
        id = "Manage Delivery Boy",
        icon = R.drawable.category2,
        title = "Manage Delivery Boy",
        showHorizontalDivider = true,
        showVerticalDivider = false
    ),
    DashboardItem(
        id = "Add Pickup Boy",
        icon = R.drawable.category1,
        title = "Add Pickup Boy",
        showHorizontalDivider = true,
        showVerticalDivider = true
    ),
    DashboardItem(
        id = "Manage Pickup boy",
        icon = R.drawable.category2,
        title = "Manage Pickup boy",
        showHorizontalDivider = true,
        showVerticalDivider = false
    ),
    DashboardItem(
        id = "View Assigned Orders",
        icon = R.drawable.category3,
        title = "View Assigned Orders",
        showHorizontalDivider = true,
        showVerticalDivider = true
    ),
    DashboardItem(
        id = "Assign Orders",
        icon = R.drawable.category4,
        title = "Assign Orders",
        showHorizontalDivider = true,
        showVerticalDivider = false
    ),
    DashboardItem(
        id = "Financial Logs",
        icon = R.drawable.category5,
        title = "Financial Logs",
        showHorizontalDivider = false,
        showVerticalDivider = true
    ),
    DashboardItem(
        id = "Reports",
        icon = R.drawable.category6,
        title = "Reports",
        showHorizontalDivider = false,
        showVerticalDivider = false
    )
)