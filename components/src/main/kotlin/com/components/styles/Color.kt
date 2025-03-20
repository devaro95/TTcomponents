package com.components.styles

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val White = Color.White
val Placeholder = Color(0xFFB0BEC5)
val Disabled = Color(0xFFE0E0E0)
val DisabledText = Color(0xFF9E9E9E)
val Error = Color(0xFFE76F51)
val BottomBar = Color(0xFFF0F0F0)
val SecondaryBackground = Color(0xFFF7F7F7)
val InputBorder = Color(0xFFE0E0E0)
val InputLegend = Color(0xFFA4A4A4)
val CardBackground = Color(0xFFFFFFFF)
val CardSecondaryBackground = Color(0xFFFAF3DD)
val GuideCardHeader = Color(0xFF7D8B92)
val CardBorder = Color(0xFFE4DCCF)
val EmptyColor = Color(0xFF5E6E76)
val EditionBackground = Color(0xA1B0BEC5)
val SectionDetailCardColor = Color.White

val TTLightColors = lightColorScheme(
    secondaryContainer = Disabled,
    primary = Color(0xFF333333),
    secondary = White,
    background = Color(0xFFF3F2ED),
    error = Error
)

val TTDarkColors = darkColorScheme(
    secondaryContainer = Disabled,
    primary = Color(0xFF333333),
    secondary = White,
    background = Color(0xFFF3F2ED),
    error = Error
)