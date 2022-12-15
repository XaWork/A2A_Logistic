package a2a.logistic.app.presentation.financiallogs

import a2a.logistic.app.presentation.components.A2ADateChooser
import a2a.logistic.app.presentation.components.A2ALogisticButton
import a2a.logistic.app.presentation.components.A2ALogisticTopAppBar
import a2a.logistic.app.presentation.ui.theme.Blue900
import a2a.logistic.app.presentation.ui.theme.MainBgColor
import a2a.logistic.app.presentation.ui.theme.ScreenPadding
import a2a.logistic.app.presentation.ui.theme.SpaceBetweenViewsAndSubViews
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FinancialRepostListScreen(
    onBackPress: () -> Unit
) {
    Scaffold(topBar = {
        A2ALogisticTopAppBar(
            title = "FINANCIAL LOGS",
            onBackPress = onBackPress
        )
    }, content = {
        val value = it
        Column {
            ContentLogFilter()
            LogReportList()
        }
    })
}

@Composable
fun ContentLogFilter() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .padding(
                ScreenPadding
            )
    ) {
        Text(
            text = "Choose Date Range To Get Report",
            color = Color.White
        )

        Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

        Row(modifier = Modifier.fillMaxWidth()) {
            A2ADateChooser(
                title = "Start Date",
                modifier = Modifier.weight(1f),
                onClick = {}
            )

            Spacer(modifier = Modifier.width(5.dp))

            A2ADateChooser(
                title = "End Date",
                modifier = Modifier.weight(1f),
                onClick = {}
            )

            Spacer(modifier = Modifier.width(5.dp))

            A2ALogisticButton(
                modifier = Modifier.weight(1f),
                title = "Submit",
                textAllCaps = true,
                buttonColor = ButtonDefaults.buttonColors(
                    backgroundColor = Blue900,
                    contentColor = Color.White
                ),
                onClick = {})
        }
    }
}

@Composable
fun LogReportList() {
    LazyColumn(modifier = Modifier.background(color = MaterialTheme.colors.MainBgColor)) {
        items(10) {
            SingleLogReportItem()
        }
    }
}

@Preview
@Composable
fun FinancialReportListScreenPreview() {
    FinancialRepostListScreen {

    }
}