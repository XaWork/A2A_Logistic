package a2a.logistic.app.presentation.dashboard

import a2a.logistic.app.presentation.components.A2ALogisticButton
import a2a.logistic.app.presentation.ui.theme.CardCornerRadius
import a2a.logistic.app.presentation.ui.theme.ScreenPadding
import a2a.logistic.app.presentation.ui.theme.SpaceBetweenViewsAndSubViews
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog

@Composable
fun LogoutDialog(
    showDialog: (Boolean) -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(onDismissRequest = { showDialog(false) }) {
        Surface(shape = RoundedCornerShape(CardCornerRadius)) {
            Box(contentAlignment = Alignment.Center) {
                Column(modifier = Modifier.padding(ScreenPadding)) {
                    Text(text = "Do you want to logout?")
                    Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))
                    Row {
                        A2ALogisticButton(
                            title = "Ok",
                            textAllCaps = false,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                onConfirm()
                                showDialog(false)
                            }
                        )

                        Spacer(modifier = Modifier.width(SpaceBetweenViewsAndSubViews))

                        A2ALogisticButton(
                            title = "Cancel",
                            textAllCaps = false,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                showDialog(false)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LogoutDialogPreview() {
    LogoutDialog(showDialog = {}) {

    }
}