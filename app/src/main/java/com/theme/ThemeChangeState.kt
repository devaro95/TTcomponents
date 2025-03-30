package com.theme

import com.theming.TTTheme
import com.theming.colors.TTColors
import com.vro.state.VROState

data class ThemeChangeState(
    val defaultColors: TTColors,
) : VROState {
    companion object {
        val INITIAL = ThemeChangeState(
            defaultColors = TTTheme.colors
        )
    }
}