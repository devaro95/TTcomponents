package com.theming.colors

import androidx.compose.ui.graphics.Color

data class TTPagerIndicatorColors(
    val selectedItemColor: Color,
    val selectedItemBorder: Color,
    val unselectedItemColor: Color,
    val unselectedItemBorder: Color
) {

    companion object {
        val defaultColors = TTPagerIndicatorColors(
            selectedItemColor = Color(0xFF492C1C),
            selectedItemBorder = Color(0xFF333333),
            unselectedItemColor = Color.White,
            unselectedItemBorder = Color(0xFF333333)
        )
    }
}