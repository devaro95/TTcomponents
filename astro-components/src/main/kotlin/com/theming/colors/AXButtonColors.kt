package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.*

data class AXButtonColors(
    val buttonText: Color,
    val buttonBackground: Color,
    val disabledButtonText: Color,
    val disabledButtonBackground: Color,
    val floatingButtonText: Color,
    val floatingButtonBackground: Color,
    val disabledFloatingButtonText: Color,
    val disabledFloatingButtonBackground: Color,
) {

    companion object {
        val defaultColors = AXButtonColors(
            buttonText = AXColor.AXWhite,
            buttonBackground = AXColor.AXCafeNoir,
            disabledButtonText = AXColor.AXWhite,
            disabledButtonBackground = AXColor.AXGrayX11,
            floatingButtonText = AXColor.AXWhite,
            floatingButtonBackground = AXColor.AXDarCharcoal,
            disabledFloatingButtonText = AXColor.AXWhite,
            disabledFloatingButtonBackground = AXColor.AXGrayX11
        )
    }
}