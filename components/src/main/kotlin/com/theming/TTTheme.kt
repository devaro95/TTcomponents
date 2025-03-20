package com.theming

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

object TTTheme {

    private var customColors: TTColors? = null

    val colorScheme: TTColors
        @Composable
        @ReadOnlyComposable
        get() = customColors ?: TTColors.defaultColors


    fun setColors(colors: TTColors) {
        customColors = colors
    }

    fun resetColors() {
        customColors = null
    }
}