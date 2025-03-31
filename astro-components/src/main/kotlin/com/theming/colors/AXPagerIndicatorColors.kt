package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.AXColor

data class AXPagerIndicatorColors(
    val selectedItemColor: Color,
    val selectedItemBorder: Color,
    val unselectedItemColor: Color,
    val unselectedItemBorder: Color,
) {

    companion object {
        val defaultColors = AXPagerIndicatorColors(
            selectedItemColor = AXColor.AXCafeNoir,
            selectedItemBorder = AXColor.AXDarCharcoal,
            unselectedItemColor = AXColor.AXWhite,
            unselectedItemBorder = AXColor.AXDarCharcoal
        )
    }
}