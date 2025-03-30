package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.TTSocialStatsColors

data class TTColors(
    val primaryColor: Color,
    val secondaryColor: Color,
    val background: Color,
    val inputColors: TTInputColors,
    val buttonColors: TTButtonColors,
    val pagerIndicatorColors: TTPagerIndicatorColors,
    val stepperIndicatorColors: TTStepperIndicatorColors,
    val cardColors: TTCardColors,
    val socialStatsColors: TTSocialStatsColors = TTSocialStatsColors.defaultColors
) {

    companion object {
        val defaultColors = TTColors(
            primaryColor = Color(0xFF333333),
            secondaryColor = Color(0xFF492C1C),
            background = Color(0xFFF3F2ED),
            inputColors = TTInputColors.defaultColors,
            buttonColors = TTButtonColors.defaultColors,
            pagerIndicatorColors = TTPagerIndicatorColors.defaultColors,
            stepperIndicatorColors = TTStepperIndicatorColors.defaultColors,
            cardColors = TTCardColors.defaultColors
        )
    }
}