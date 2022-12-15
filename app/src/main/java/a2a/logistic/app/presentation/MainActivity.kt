package a2a.logistic.app.presentation

import a2a.logistic.app.presentation.navigation.Navigation
import a2a.logistic.app.presentation.ui.theme.A2ALogisticTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A2ALogisticTheme {
                Navigation()
            }
        }
    }
}
