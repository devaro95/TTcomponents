package com.components.styles

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ttcomponents.app.R

//TODO COLOR
val TTTypography = Typography(
    bodySmall = TextStyle(
        color = Color(0xFF333333),
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.main_font_light))
    ),
    bodyMedium = TextStyle(
        color = Color(0xFF333333),
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.main_font_light))
    ),
    bodyLarge = TextStyle(
        fontSize = 18.sp,
        fontFamily = FontFamily(Font(R.font.main_font_medium))
    ),
    titleSmall = TextStyle(
        color = Color(0xFF333333),
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.main_font_light))
    ),
    titleMedium = TextStyle(
        color = Color(0xFF333333),
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.main_font_light))
    ),
    titleLarge = TextStyle(
        color = Color(0xFF333333),
        fontSize = 18.sp,
        fontFamily = FontFamily(Font(R.font.main_font_light))
    ),
    headlineSmall = TextStyle(
        color = Color(0xFF333333),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.main_font_medium))
    ),
    headlineMedium = TextStyle(
        color = Color(0xFF333333),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.main_font_medium))
    ),
    headlineLarge = TextStyle(
        color = Color(0xFF333333),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.main_font_medium))
    ),
    displayMedium = TextStyle(
        color = Color(0xFF333333),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.main_font_medium))
    ),
    displayLarge = TextStyle(
        color = Color(0xFF333333),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.main_font_medium))
    ),
)