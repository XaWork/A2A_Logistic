package a2a.logistic.app.presentation.adduser

import a2a.logistic.app.presentation.components.A2ALogisticButton
import a2a.logistic.app.presentation.ui.theme.CardCornerRadius
import a2a.logistic.app.presentation.ui.theme.CardElevation
import a2a.logistic.app.presentation.ui.theme.ScreenPadding
import a2a.logistic.app.presentation.ui.theme.SpaceBetweenViews
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AddOrEditUserConfirmationDialog(
    showDialog: (Boolean) -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(onDismissRequest = { showDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(CardCornerRadius),
            elevation = CardElevation
        ) {
            Box(contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier
                        .padding(ScreenPadding)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "User added successfully.")
                    Spacer(modifier = Modifier.height(SpaceBetweenViews))
                    A2ALogisticButton(
                        title = "Ok",
                        textAllCaps = true,
                        modifier = Modifier.width(100.dp)
                    ) {
                        onConfirm()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DialogPreview() {
    AddOrEditUserConfirmationDialog(showDialog = {}) {

    }
}