package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.AXColor

data class AXMenuColors(
    val checkedThumbColor: Color,
    val checkedTrackColor: Color,
    val uncheckedThumbColor: Color,
    val uncheckedTrackColor: Color,
    val borderColor: Color,
    val containerColor: Color
) {

    companion object {
        val defaultColors = AXMenuColors(
            checkedThumbColor = AXColor.AXCafeNoir,
            checkedTrackColor = AXColor.AXCafeNoir,
            uncheckedThumbColor = AXColor.AXWhite,
            uncheckedTrackColor = AXColor.AXCafeNoir,
            borderColor = AXColor.AXChineseWhite,
            containerColor = AXColor.AXCultured
        )
    }
}