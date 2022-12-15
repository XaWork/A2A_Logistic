package a2a.logistic.app.presentation.components

import a2a.logistic.app.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun A2ALogisticTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    enable: Boolean = true,
    leadingIcon: Int,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions()
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
        singleLine = singleLine,
        modifier = modifier.fillMaxWidth(),
        enabled = enable,
        keyboardOptions = keyboardOptions,

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