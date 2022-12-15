package a2a.logistic.app.presentation.order

import a2a.logistic.app.presentation.components.A2ADateChooser
import a2a.logistic.app.presentation.components.A2ALogisticTopAppBar
import a2a.logistic.app.presentation.ui.theme.ScreenPadding
import a2a.logistic.app.presentation.ui.theme.SpaceBetweenViewsAndSubViews
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MyOrderListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            A2ALogisticTopAppBar(title = "Assign Orders") {
                navController.popBackStack()
            }
        },
        content = { paddingValues ->
            val value = paddingValues
            ContentMyOrder()
        })
}

@Composable
fun ContentMyOrder() {
    Column(
        modifier = Modifier
            .background(color = Color.LightGray)
    ) {
        ContentFilter()
        OrderList()
    }

}

@Composable
private fun ContentFilter() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.primary
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(ScreenPadding)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Choose data range to filter order list",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Row(modifier = Modifier.fillMaxWidth()) {
                A2ADateChooser(
                    modifier = Modifier.weight(1f),
                    title = "Start date",
                    onClick = {}
                )

                Spacer(modifier = Modifier.width(2.dp))

                A2ADateChooser(
                    modifier = Modifier.weight(1f),
                    title = "End date",
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun OrderList() {
    LazyColumn {
        items(10) {
            OrderListItem()
        }
    }
}

@Preview
@Composable
fun MyOrderScreenPreview() {
    MyOrderListScreen(rememberNavController())
}