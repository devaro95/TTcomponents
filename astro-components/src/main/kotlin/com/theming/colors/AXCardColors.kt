package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.AXColor

data class AXCardColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
) {

    companion object {
        val defaultColors = AXCardColors(
            containerColor = AXColor.AXWhite,
            disabledContainerColor = Color.Unspecified,
            contentColor = AXColor.AXDarCharcoal,
            disabledContentColor = AXColor.AXDarCharcoal.copy(0.38f)
        )
    }
}