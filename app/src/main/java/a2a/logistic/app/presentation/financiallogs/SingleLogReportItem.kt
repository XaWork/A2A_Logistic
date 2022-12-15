package a2a.logistic.app.presentation.financiallogs

import a2a.logistic.app.presentation.ui.theme.CardBg
import a2a.logistic.app.presentation.ui.theme.CardCornerRadius
import a2a.logistic.app.presentation.ui.theme.CardElevation
import a2a.logistic.app.presentation.ui.theme.ScreenPadding
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SingleLogReportItem() {
    Card(
        modifier = Modifier
            .padding(horizontal = ScreenPadding, vertical = 5.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(CardCornerRadius))
            .background(color = MaterialTheme.colors.CardBg),
        elevation = CardElevation
    ) {
        Column(modifier = Modifier.padding(ScreenPadding)) {
            Text(text = "Title", fontSize = 16.sp, color = Color.Black)
            Text(text = "$20.00", fontSize = 14.sp, color = Color.DarkGray)
            Text(text = "decp", fontSize = 14.sp, color = Color.DarkGray)
            Text(text = "decp", fontSize = 14.sp, color = Color.DarkGray)
            Text(text = "decp", fontSize = 14.sp, color = Color.DarkGray)
        }
    }
}

@Preview
@Composable
fun SingleLogReportItemPreview() {
    SingleLogReportItem()
}