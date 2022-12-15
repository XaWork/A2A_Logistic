package a2a.logistic.app.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun A2AMainTopAppBar(
    onLogOutClick: () -> Unit
) {
    TopAppBar(
        elevation = 0.dp,
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Hello")
            }
        },
        actions = {
            IconButton(onClick = onLogOutClick) {
                Icon(
                    painter = painterResource(id = a2a.logistic.app.R.drawable.logout),
                    contentDescription = "Log out",
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    )

}