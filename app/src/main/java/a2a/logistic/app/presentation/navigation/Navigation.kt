package a2a.logistic.app.presentation.navigation

import a2a.logistic.app.domain.model.usermodel.AddLogisticsBoyResponse
import a2a.logistic.app.presentation.adduser.AddUserScreen
import a2a.logistic.app.presentation.dashboard.DashboardScreen
import a2a.logistic.app.presentation.financiallogs.FinancialRepostListScreen
import a2a.logistic.app.presentation.login.LoginScreen
import a2a.logistic.app.presentation.manageuser.MyUserListScreen
import a2a.logistic.app.presentation.order.MyOrderListScreen
import a2a.logistic.app.presentation.splash.SplashScreen
import a2a.logistic.app.presentation.userdetails.UserDetailsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Screen.SplashScreen.route
    ) {
        //------------------------------------ Splash -----------------------------------------

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(onNavigateToLoginScreen = {
                navController.navigate(Screen.LoginScreen.route) {
                    popUpTo(Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }, onNavigateToDashboardScreen = {
                navController.navigate(Screen.DashboardScreen.route) {
                    popUpTo(Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }, onNavigateToOrderScreen = {
                navController.navigate(Screen.MyOrderListScreen.route) {
                    popUpTo(Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            })
        }

        //------------------------------------ Login -----------------------------------------

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(onNavigateToDashboardScreen = {
                navController.navigate(Screen.DashboardScreen.route) {
                    popUpTo(Screen.LoginScreen.route) {
                        inclusive = true
                    }
                }
            }, onNavigateToOrderScreen = {
                navController.navigate(Screen.MyOrderListScreen.route) {
                    popUpTo(Screen.LoginScreen.route) {
                        inclusive = true
                    }
                }
            })
        }

        // ------------------------------------ Dashboard -----------------------------------------

        composable(route = Screen.DashboardScreen.route) {
            DashboardScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(Screen.LoginScreen.route) {
                        popUpTo(Screen.DashboardScreen.route) {
                            inclusive = true
                        }
                    }
                },
                onNavigateToAddUserScreen = {
                    navController.navigate(Screen.AddUserScreen.route)
                },
                onNavigateToMyUserListScreen = {
                    navController.navigate(Screen.MyUserListScreen.route)
                },
                onNavigateToMyOrderListScreen = {
                    navController.navigate(Screen.MyOrderListScreen.route)
                },
                onNavigateToFinancialLogScreen = {
                    navController.navigate(Screen.FinancialReportScreen.route)
                }
            )
        }


        // ------------------------------------ My Order -----------------------------------------

        composable(route = Screen.MyOrderListScreen.route) {
            MyOrderListScreen(navController = navController)
        }


        // ------------------------------------ Add User -----------------------------------------

        composable(route = Screen.AddUserScreen.route) {
            AddUserScreen(
                onBackPress = {
                    navController.popBackStack()
                },
                onNavigateToUserDetailsScreen = { args ->
                    navController.navigate(
                        Screen.UserDetailsScreen.withArgs(
                            Gson().toJson(
                                args,
                                AddLogisticsBoyResponse::class.java
                            )
                        )
                    ) {
                        popUpTo(Screen.AddUserScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // ------------------------------------ User Details ---------------------------------------

        composable(
            route = Screen.UserDetailsScreen.route,
            arguments = listOf(
                navArgument(name = "user_details") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) { entry ->
            UserDetailsScreen(
                addLogisticsBoyResponse = Gson().fromJson(
                    entry.arguments?.getString("user_details"),
                    AddLogisticsBoyResponse::class.java
                )
            )
        }

        // ------------------------------------ User Details ---------------------------------------

        composable(
            route = Screen.MyUserListScreen.route
        ) {
            MyUserListScreen(onBackPress = {
                navController.popBackStack()
            },
                onNavigateToUserDetailsScreen = {
                    navController.navigate(Screen.AddUserScreen.route)
                })
        }

        // ------------------------------------ Financial Report ---------------------------------------

        composable(
            route = Screen.FinancialReportScreen.route
        ) {
            FinancialRepostListScreen(onBackPress = {
                navController.popBackStack()
            })
        }
    }
}