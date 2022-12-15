package a2a.logistic.app.presentation.navigation

sealed class Screen(val route: String){
    object SplashScreen: Screen("splash")
    object LoginScreen: Screen("login")
    object DashboardScreen: Screen("dashboard")
    object MyOrderListScreen: Screen("order_list")
    object AddUserScreen: Screen("add_user")
    object UserDetailsScreen: Screen("user_details")
    object MyUserListScreen: Screen("user_list")
    object FinancialReportScreen: Screen("financial")

    fun withArgs(vararg args: String):String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
