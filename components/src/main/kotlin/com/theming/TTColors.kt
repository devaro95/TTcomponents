package com.theming

import androidx.compose.ui.graphics.Color

data class TTColors(
    val primaryColor: Color,
    val secondaryColor: Color,
    val background: Color,
    val buttonText: Color,
    val buttonBackground: Color,
    val disabledButtonText: Color,
    val disabledButtonBackground: Color,
    val floatingButtonText: Color,
    val floatingButtonBackground: Color,
    val disabledFloatingButtonText: Color,
    val disabledFloatingButtonBackground: Color,
    val inputColors: TTInputColors,
) {

    data class TTInputColors(
        val focusedContainerColor: Color,
        val unfocusedContainerColor: Color,
        val disabledContainerColor: Color,
        val focusedIndicatorColor: Color,
        val unfocusedIndicatorColor: Color,
        val disabledIndicatorColor: Color,
        val borderColor: Color,
        val errorIndicatorColor: Color,
        val errorContainerColor: Color,
        val errorTextColor: Color,
        val errorBorderColor: Color,
        val placeholderColor: Color,
    ) {
        companion object {
            val defaultColors = TTInputColors(
                focusedContainerColor = Color(0xFFF7F7F7),
                unfocusedContainerColor = Color(0xFFF7F7F7),
                disabledContainerColor = Color(0xFFF7F7F7),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                borderColor = Color(0xFFE0E0E0),
                errorIndicatorColor = Color.Transparent,
                errorContainerColor = Color(0xFFF7F7F7),
                errorTextColor = Color(0xFFF44336),
                errorBorderColor = Color(0xFFF44336),
                placeholderColor = Color(0xFFB0BEC5)
            )
        }
    }

    companion object {
        val defaultColors = TTColors(
            primaryColor = Color(0xFF333333),
            secondaryColor = Color(0xFF492C1C),
            background = Color(0xFFF3F2ED),
            buttonText = Color(0xFFFFFFFF),
            buttonBackground = Color(0xFF492C1C),
            disabledButtonText = Color(0xFFFFFFFF),
            disabledButtonBackground = Color(0xFFBABABA),
            floatingButtonText = Color(0xFFFFFFFF),
            floatingButtonBackground = Color(0xFF333333),
            disabledFloatingButtonText = Color(0xFFFFFFFF),
            disabledFloatingButtonBackground = Color(0xFFBABABA),
            inputColors = TTInputColors.defaultColors
        )
    }
}

