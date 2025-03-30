package com.theming.colors

import androidx.compose.ui.graphics.Color

data class TTStepperIndicatorColors(
    val selectedItemTextColor: Color,
    val selectedItemColor: Color,
    val selectedItemBorder: Color,
    val unselectedItemTextColor: Color,
    val unselectedItemColor: Color,
    val unselectedItemBorder: Color,
) {

    companion object {
        val defaultColors = TTStepperIndicatorColors(
            selectedItemTextColor = Color.White,
            selectedItemColor = Color(0xFF492C1C),
            selectedItemBorder = Color(0xFF333333),
            unselectedItemTextColor = Color(0xFF333333),
            unselectedItemColor = Color.White,
            unselectedItemBorder = Color(0xFF333333)
        )
    }
}