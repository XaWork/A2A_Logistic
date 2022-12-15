package a2a.logistic.app.presentation.components

import a2a.logistic.app.R
import a2a.logistic.app.presentation.ui.theme.CardCornerRadius
import a2a.logistic.app.presentation.ui.theme.HighPadding
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun A2ADateChooser(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(HighPadding)
            .clip(RoundedCornerShape(CardCornerRadius))
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.calender),
            contentDescription = "",
            modifier = Modifier
                .width(20.dp)
        )

        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun A2ADateChooserPreview() {
    A2ADateChooser(title = "Start Date") {

    }
}