package com.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.model.ColorConfiguration
import com.model.Configuration
import com.theme.ThemeChangeEvents.ColorChange
import com.theme.ThemeChangeEvents.Confirm
import com.theme.ThemeChangeEvents.Style
import com.theme.ThemeChangeNavigator.ThemeChangeDestinations.StyleDestination
import com.theming.TTTheme
import com.vro.compose.VROComposableViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ThemeChangeViewModel : VROComposableViewModel<ThemeChangeState, ThemeChangeNavigator.ThemeChangeDestinations, ThemeChangeEvents>() {

    override val initialState = ThemeChangeState.INITIAL

    override fun onEvent(event: ThemeChangeEvents) {
        when (event) {
            is Style -> onStyleClick(event.colorConfiguration)
            is ColorChange -> onColorChange(event.configuration, event.color)
            Confirm -> onConfirmClick()
        }
    }

    override fun onStart() {
        updateScreen {
            copy(
                defaultColors = TTTheme.colors
            )
        }
    }

    private fun onStyleClick(colorConfiguration: ColorConfiguration) {
        navigate(StyleDestination(colorConfiguration))
    }

    private fun onColorChange(configuration: Configuration, color: Color) {
        when (configuration) {
            Configuration.PRIMARY_COLOR -> onPrimaryColorChange(color)
            Configuration.SECONDARY_COLOR -> onSecondaryColorChange(color)
            Configuration.BACKGROUND -> onBackgroundChange(color)
            Configuration.BUTTON_BACKGROUND -> onButtonBackgroundColorChange(color)
            Configuration.BUTTON_TEXT -> onButtonTextColorChange(color)
            Configuration.INPUT_FOCUSED_BACKGROUND -> onInputFocusedBackgroundChange(color)
            Configuration.INPUT_UNFOCUSED_BACKGROUND -> onInputUnfocusedBackgroundChange(color)
            Configuration.INPUT_BORDER -> onInputBorderChange(color)
        }
    }

    private fun onPrimaryColorChange(color: Color) {
        updateScreen {
            copy(
                defaultColors = defaultColors.copy(
                    primaryColor = color
                )
            )
        }
    }

    private fun onSecondaryColorChange(color: Color) {
        updateScreen {
            copy(
                defaultColors = defaultColors.copy(
                    secondaryColor = color
                )
            )
        }
    }

    private fun onBackgroundChange(color: Color) {
        updateScreen {
            copy(
                defaultColors = defaultColors.copy(
                    background = color
                )
            )
        }
    }

    private fun onButtonBackgroundColorChange(color: Color) {
        updateScreen {
            copy(
                defaultColors = defaultColors.copy(
                    buttonColors = defaultColors.buttonColors.copy(
                        buttonBackground = color
                    )
                )
            )
        }
    }

    private fun onButtonTextColorChange(color: Color) {
        updateScreen {
            copy(
                defaultColors = defaultColors.copy(
                    buttonColors = defaultColors.buttonColors.copy(
                        buttonText = color
                    )
                )
            )
        }
    }

    private fun onInputFocusedBackgroundChange(color: Color) {
        updateScreen {
            copy(
                defaultColors = defaultColors.copy(
                    inputColors = defaultColors.inputColors.copy(
                        focusedContainerColor = color
                    )
                )
            )
        }
    }

    private fun onInputUnfocusedBackgroundChange(color: Color) {
        updateScreen {
            copy(
                defaultColors = defaultColors.copy(
                    inputColors = defaultColors.inputColors.copy(
                        unfocusedContainerColor = color
                    )
                )
            )
        }
    }

    private fun onInputBorderChange(color: Color) {
        updateScreen {
            copy(
                defaultColors = defaultColors.copy(
                    inputColors = defaultColors.inputColors.copy(
                        borderColor = color
                    )
                )
            )
        }
    }

    private fun onConfirmClick() {
        checkDataState().also {
            TTTheme.setColors { it.defaultColors }
        }
    }

    companion object {
        fun Color.toHex(): String {
            val argb = this.toArgb()
            return if (this.alpha == 1.0f) {
                String.format("#%06X", argb and 0xFFFFFF)
            } else {
                String.format("#%08X", argb)
            }
        }
    }
}