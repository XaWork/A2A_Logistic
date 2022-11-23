package a2a.logistic.app.presentation.components

import a2a.logistic.app.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun A2ALogisticTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: Int
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = label) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = ""
            )
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun A2ALogisticTextFieldPreview() {
    A2ALogisticTextField(
        value = "",
        onValueChange = {},
        label = "full name",
        leadingIcon = R.drawable.mobile
    )
}