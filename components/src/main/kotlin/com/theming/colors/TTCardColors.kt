package com.theming.colors

import androidx.compose.ui.graphics.Color

data class TTCardColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
) {

    companion object {
        val defaultColors = TTCardColors(
            containerColor = Color.White,
            disabledContainerColor = Color.Unspecified,
            contentColor = Color(0xFF333333),
            disabledContentColor = Color(0xFF333333).copy(0.38f)
        )
    }
}