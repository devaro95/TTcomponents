package com.theming

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.theming.colors.AXColors

object AXTheme {

    private var customColors: AXColors = AXColors.defaultColors

    val colorScheme: AXColors
        @Composable
        @ReadOnlyComposable
        get() = customColors


    fun setColors(colors: AXColors.() -> AXColors) {
        customColors = colors.invoke(customColors)
    }

    fun resetColors() {
        customColors = AXColors.defaultColors
    }

    val colors: AXColors
        get() = customColors
}