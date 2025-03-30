package com.theming.colors

import androidx.compose.ui.graphics.Color

data class TTButtonColors(
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
        val defaultColors = TTButtonColors(
            buttonText = Color(0xFFFFFFFF),
            buttonBackground = Color(0xFF492C1C),
            disabledButtonText = Color(0xFFFFFFFF),
            disabledButtonBackground = Color(0xFFBABABA),
            floatingButtonText = Color(0xFFFFFFFF),
            floatingButtonBackground = Color(0xFF333333),
            disabledFloatingButtonText = Color(0xFFFFFFFF),
            disabledFloatingButtonBackground = Color(0xFFBABABA)
        )
    }
}