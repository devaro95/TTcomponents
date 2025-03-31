package com.theming.colors

import androidx.compose.ui.graphics.Color
import com.theming.AXColor

data class AXInputColors(
    val focusedContainerColor: Color,
    val unfocusedContainerColor: Color,
    val disabledContainerColor: Color,
    val focusedIndicatorColor: Color,
    val unfocusedIndicatorColor: Color,
    val disabledIndicatorColor: Color,
    val borderColor: Color,
    val errorIndicatorColor: Color,
    val errorContainerColor: Color,
    val errorTextColor: Color,
    val errorBorderColor: Color,
    val placeholderColor: Color,
    val legendColor: Color,
) {
    companion object {
        val defaultColors = AXInputColors(
            focusedContainerColor = AXColor.AXCultured,
            unfocusedContainerColor = AXColor.AXCultured,
            disabledContainerColor = AXColor.AXCultured,
            focusedIndicatorColor = AXColor.AXTransparent,
            unfocusedIndicatorColor = AXColor.AXTransparent,
            disabledIndicatorColor = AXColor.AXTransparent,
            borderColor = AXColor.AXChineseWhite,
            errorIndicatorColor = AXColor.AXTransparent,
            errorContainerColor = AXColor.AXCultured,
            errorTextColor = AXColor.AXCoralRed,
            errorBorderColor = AXColor.AXCoralRed,
            placeholderColor = AXColor.AXPastelBlue,
            legendColor = AXColor.AXQuickSilver
        )
    }
}