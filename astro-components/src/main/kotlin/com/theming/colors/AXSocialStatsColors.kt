package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.AXColor

data class AXSocialStatsColors(
    val likeIconColor: Color,
    val likeTextColor: Color,
    val unlikeIconColor: Color,
    val unlikeTextColor: Color,
    val saveIconColor: Color,
    val saveTextColor: Color,
    val unsaveIconColor: Color,
    val unsaveTextColor: Color,
) {

    companion object {
        val defaultColors = AXSocialStatsColors(
            likeIconColor = AXColor.AXDarCharcoal,
            likeTextColor = AXColor.AXDarCharcoal,
            unlikeIconColor = AXColor.AXDarCharcoal,
            unlikeTextColor = AXColor.AXDarCharcoal,
            saveIconColor = AXColor.AXDarCharcoal,
            saveTextColor = AXColor.AXDarCharcoal,
            unsaveIconColor = AXColor.AXDarCharcoal,
            unsaveTextColor = AXColor.AXDarCharcoal
        )
    }
}