package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.AXColor

data class AXDatePickerColors(
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
        val defaultColors = AXDatePickerColors(
            selectedDayContentColor = AXColor.AXWhite,
            dividerColor = AXColor.AXIsabelline,
            yearContentColor = AXColor.AXDarCharcoal,
            selectedYearContentColor = AXColor.AXIsabelline,
            selectedYearContainerColor = AXColor.AXDarCharcoal,
            containerColor = AXColor.AXIsabelline,
            disabledDayContentColor = AXColor.AXPastelBlue,
            dayContentColor = AXColor.AXDarCharcoal,
            weekdayContentColor = AXColor.AXDarCharcoal,
            todayContentColor = AXColor.AXDarCharcoal,
            navigationContentColor = AXColor.AXDarCharcoal,
        )
    }
}