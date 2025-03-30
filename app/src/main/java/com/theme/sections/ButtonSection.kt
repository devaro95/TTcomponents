package com.theme.sections

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.model.Configuration
import com.theme.*
import com.theme.ThemeChangeEvents.ColorChange

@Composable
fun ButtonSection(state: ThemeChangeState, onColorChange: (Configuration, Color) -> Unit) {
    TTThemeList(
        title = "Button",
        content = {
            TTThemeListItem(
                configuration = Configuration.BUTTON_BACKGROUND,
                color = state.defaultColors.buttonColors.buttonBackground,
                onChange = { configuration, color -> onColorChange(configuration, color) }
            )
            TTThemeListItem(
                configuration = Configuration.BUTTON_TEXT,
                color = state.defaultColors.buttonColors.buttonText,
                onChange = { configuration, color -> onColorChange(configuration, color) }
            )
        }
    )
}