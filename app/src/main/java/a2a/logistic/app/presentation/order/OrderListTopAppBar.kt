package a2a.logistic.app.presentation.order

import a2a.logistic.app.R
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun OrderListTopAppBar() {
    TopAppBar(title = {
        Text(text = "A2A Logistics App", fontSize = 12.sp)
    }, contentColor = Color.White,
    actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painterResource(id = R.drawable.ic_baseline_account_balance_wallet_24), contentDescription = "")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painterResource(id = R.drawable.logout), contentDescription = "")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "")
        }
    })
}

@Preview
@Composable
fun OrderListTopBarPreview() {
    OrderListTopAppBar()
}