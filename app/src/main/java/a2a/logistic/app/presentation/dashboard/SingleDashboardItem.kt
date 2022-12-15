package a2a.logistic.app.presentation.dashboard

import a2a.logistic.app.R
import a2a.logistic.app.presentation.ui.theme.SpaceBetweenViews
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SingleDashboardItem(
    item: DashboardItem,
    onItemClick: (DashboardItem) -> Unit
) {
    Row(
        modifier = Modifier
            .background(color = Color.White)
            .clickable { onItemClick(item) },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = item.icon),
                contentDescription = item.title,
                modifier = Modifier.padding(10.dp)
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViews))

            Text(
                text = item.title,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(10.dp)
            )

            if (item.showHorizontalDivider)
                Divider()
        }

        if (item.showVerticalDivider)
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
    }
}

@Preview
@Composable
fun SingleDashboardItemPreview() {
    SingleDashboardItem(
        item = DashboardItem(
            id = "1",
            icon = R.drawable.category1,
            title = "Add Delivery Boy",
            showHorizontalDivider = true,
            showVerticalDivider = true
        ), onItemClick = {}
    )
}