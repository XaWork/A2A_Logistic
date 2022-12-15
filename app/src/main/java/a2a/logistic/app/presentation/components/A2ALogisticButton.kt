package a2a.logistic.app.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun A2ALogisticButton(
    modifier: Modifier = Modifier,
    title: String = "A2A Logistic Button",
    textAllCaps: Boolean = false,
    buttonColor: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        colors = buttonColor
    ) {
        Text(text = if (textAllCaps) title.uppercase() else title)
    }
}

@Preview
@Composable
fun A2ALogisticButtonPreview() {

}