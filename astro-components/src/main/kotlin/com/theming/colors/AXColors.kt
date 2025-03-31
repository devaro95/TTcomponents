package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.AXColor

data class AXColors(
    val primaryColor: Color,
    val secondaryColor: Color,
    val background: Color,
    val inputColors: AXInputColors,
    val buttonColors: AXButtonColors,
    val pagerIndicatorColors: AXPagerIndicatorColors,
    val stepperIndicatorColors: AXStepperIndicatorColors,
    val cardColors: AXCardColors,
    val socialStatsColors: AXSocialStatsColors = AXSocialStatsColors.defaultColors,
    val menuColors: AXMenuColors = AXMenuColors.defaultColors,
) {

    companion object {
        val defaultColors = AXColors(
            primaryColor = AXColor.AXDarCharcoal,
            secondaryColor = AXColor.AXCafeNoir,
            background = AXColor.AXIsabelline,
            inputColors = AXInputColors.defaultColors,
            buttonColors = AXButtonColors.defaultColors,
            pagerIndicatorColors = AXPagerIndicatorColors.defaultColors,
            stepperIndicatorColors = AXStepperIndicatorColors.defaultColors,
            cardColors = AXCardColors.defaultColors
        )
    }
}