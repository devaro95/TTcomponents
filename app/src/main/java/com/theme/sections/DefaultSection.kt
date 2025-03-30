package com.theme.sections

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.model.Configuration
import com.theme.*

@Composable
fun DefaultSection(state: ThemeChangeState, onColorChange: (Configuration, Color) -> Unit) {
    TTThemeList(
        title = "Default",
        content = {
            TTThemeListItem(
                configuration = Configuration.PRIMARY_COLOR,
                color = state.defaultColors.primaryColor,
                onChange = { configuration, color -> onColorChange(configuration, color) }
            )
            TTThemeListItem(
                configuration = Configuration.SECONDARY_COLOR,
                color = state.defaultColors.secondaryColor,
                onChange = { configuration, color -> onColorChange(configuration, color) }
            )
            TTThemeListItem(
                configuration = Configuration.BACKGROUND,
                color = state.defaultColors.background,
                onChange = { configuration, color -> onColorChange(configuration, color) }
            )
        }
    )
}