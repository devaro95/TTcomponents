package com.theme

import androidx.compose.ui.graphics.Color
import com.model.ColorConfiguration
import com.model.Configuration
import com.vro.event.VROEvent

sealed class ThemeChangeEvents : VROEvent {
    data object Confirm : ThemeChangeEvents()
    data class Style(val colorConfiguration: ColorConfiguration) : ThemeChangeEvents()
    data class ColorChange(val configuration: Configuration, val color: Color) : ThemeChangeEvents()
}