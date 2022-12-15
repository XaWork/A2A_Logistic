package a2a.logistic.app.presentation.order

import a2a.logistic.app.R
import a2a.logistic.app.presentation.ui.theme.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrderListItem() {
    var bundleCheck by remember {
        mutableStateOf(false)
    }
    var customerPhoneCheck by remember {
        mutableStateOf(false)
    }
    var sendNotificationCheck by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(horizontal = ScreenPadding, vertical = 5.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(CardCornerRadius)),
        elevation = CardElevation
    ) {
        Column(modifier = Modifier.padding(MediumPadding)) {
            Text(
                text = "Title",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = bundleCheck,
                    onCheckedChange = { bundleCheck = it },
                    modifier = Modifier.padding(0.dp)
                )

                Text(
                    text = "Check for Bundle",
                    color = Color.Black,
                    modifier = Modifier.weight(1f),
                )

                Icon(
                    painter = painterResource(id = R.drawable.report_icon),
                    contentDescription = "",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.width(20.dp)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "Print QR",
                    modifier = Modifier.weight(1f),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.calender),
                    contentDescription = "",
                    modifier = Modifier
                        .width(20.dp),
                    tint = MaterialTheme.colors.primary
                )

                Spacer(modifier = Modifier.width(2.dp))

                Text(
                    text = "Date",
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    painter = painterResource(id = R.drawable.time),
                    contentDescription = "",
                    modifier = Modifier
                        .width(20.dp),
                    tint = MaterialTheme.colors.primary
                )

                Spacer(modifier = Modifier.width(2.dp))

                Text(
                    text = "Time",
                    modifier = Modifier.weight(1f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "City",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Order City",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Order Distance",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Pickup Weight",
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                )

                Text(
                    text = "Delivery Weight",
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                )
            }

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Update Weight",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.End)
                    .background(MaterialTheme.colors.primary)
                    .padding(LowPadding)
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Price",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Description",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Delivery Zip Code",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Delivery Zip Code",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Manage Partner Name",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Manage Partner Phone",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = customerPhoneCheck,
                    onCheckedChange = { customerPhoneCheck = it },
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Text(
                    text = "Customer Phone",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(1f)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = sendNotificationCheck,
                    onCheckedChange = { sendNotificationCheck = it },
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Text(
                    text = "Send Notification",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.fillMaxWidth(1f)
                )
            }

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Customer Address",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Express",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Payment Mode",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Delivery Date",
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                )

                Text(
                    text = "Delivery Time",
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                )
            }

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Status",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp,
                color = MaterialTheme.colors.primary,
            )

            Spacer(modifier = Modifier.height(SpaceBetweenViewsAndSubViews))

            Text(
                text = "Assigned Status",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp,
                color = MaterialTheme.colors.primary,
            )
        }
    }
}

@Preview
@Composable
fun OrderListItemPreview() {
    OrderListItem()
}