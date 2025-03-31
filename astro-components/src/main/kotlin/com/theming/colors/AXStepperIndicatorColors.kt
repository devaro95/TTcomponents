package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.AXColor

data class AXStepperIndicatorColors(
    val selectedItemTextColor: Color,
    val selectedItemColor: Color,
    val selectedItemBorder: Color,
    val unselectedItemTextColor: Color,
    val unselectedItemColor: Color,
    val unselectedItemBorder: Color,
) {

    companion object {
        val defaultColors = AXStepperIndicatorColors(
            selectedItemTextColor = AXColor.AXWhite,
            selectedItemColor = AXColor.AXCafeNoir,
            selectedItemBorder = AXColor.AXDarCharcoal,
            unselectedItemTextColor = AXColor.AXDarCharcoal,
            unselectedItemColor = AXColor.AXWhite,
            unselectedItemBorder = AXColor.AXDarCharcoal
        )
    }
}