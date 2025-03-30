package com.theme.sections

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.model.Configuration
import com.theme.*
import com.theme.ThemeChangeEvents.ColorChange

@Composable
fun InputSection(state: ThemeChangeState, onColorChange: (Configuration, Color) -> Unit) {
    TTThemeList(
        title = "Input",
        content = {
            TTThemeListItem(
                configuration = Configuration.INPUT_FOCUSED_BACKGROUND,
                color = state.defaultColors.inputColors.focusedContainerColor,
                onChange = { configuration, color -> onColorChange(configuration, color) }
            )
            TTThemeListItem(
                configuration = Configuration.INPUT_UNFOCUSED_BACKGROUND,
                color = state.defaultColors.inputColors.unfocusedContainerColor,
                onChange = { configuration, color -> onColorChange(configuration, color) }
            )
            TTThemeListItem(
                configuration = Configuration.INPUT_BORDER,
                color = state.defaultColors.inputColors.borderColor,
                onChange = { configuration, color -> onColorChange(configuration, color) }
            )
        }
    )
}