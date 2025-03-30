package com.theming.colors

import androidx.compose.ui.graphics.Color

data class TTDatePickerColors(
    val selectedDayContentColor: Color,
    val dividerColor: Color,
    val yearContentColor: Color,
    val selectedYearContentColor: Color,
    val selectedYearContainerColor: Color,
    val containerColor: Color,
    val disabledDayContentColor: Color,
    val dayContentColor: Color,
    val weekdayContentColor: Color,
    val todayContentColor: Color,
    val navigationContentColor: Color,
) {
    companion object {
        val defaultColors = TTDatePickerColors(
            selectedDayContentColor = Color.Companion.White,
            dividerColor = Color(0xFFF3F2ED),
            yearContentColor = Color(0xFF333333),
            selectedYearContentColor = Color(0xFFF3F2ED),
            selectedYearContainerColor = Color(0xFF333333),
            containerColor = Color(0xFFF3F2ED),
            disabledDayContentColor = Color(0xFFB0BEC5),
            dayContentColor = Color(0xFF333333),
            weekdayContentColor = Color(0xFF333333),
            todayContentColor = Color(0xFF333333),
            navigationContentColor = Color(0xFF333333),
        )
    }
}