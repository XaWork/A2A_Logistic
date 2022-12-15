package a2a.logistic.app.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

//------------------------------------------------

val Blue800 = Color(0xFF076ca3)
val Blue500 = Color(0xFF539ad5)
val Blue100 = Color(0xFFb1e1f3)

val Blue900 = Color(0XFF004274)
val Blue700 = Color(0XFF085068)
val Blue300 = Color(0XFF007ac5)

val MainLightBg = Color(0XFFe9ebf0)
val MainDarkBg = Color(0xFF28292D)

val DividerLightBg = Color(0XFF000000)
val DividerDarkBg = Color(0xFFA4A4A7)

val CardLightBg = Color(0XFFFFFFFF)
val CardDarkBg = Color(0xFF1B1B1B)

val Green500 = Color(0xFF1DBF73)
val Green700 = Color(0xFF13804D)
val Gray700 = Color(0xFFC4C4C4)
val Gray200 = Color(0xFFF4F4F4)

val HintColor = Color(0xFF969696)

val Colors.buttonBackground: Color
    @Composable
    get() = if(isLight) Green700 else Color.Black

val Colors.MainBgColor: Color
    @Composable
    get() = if(!isSystemInDarkTheme()) MainLightBg else MainDarkBg

val Colors.CardBg: Color
    @Composable
    get() = if(!isSystemInDarkTheme()) CardLightBg else CardDarkBg
