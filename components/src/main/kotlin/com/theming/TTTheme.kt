package com.theming

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.theming.colors.TTColors

object TTTheme {

    private var customColors: TTColors = TTColors.defaultColors

    val colorScheme: TTColors
        @Composable
        @ReadOnlyComposable
        get() = customColors


    fun setColors(colors: TTColors.() -> TTColors) {
        customColors = colors.invoke(customColors)
    }

    fun resetColors() {
        customColors = TTColors.defaultColors
    }

    val colors: TTColors
        get() = customColors
}