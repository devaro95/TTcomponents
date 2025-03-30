package com.theming.colors

import androidx.compose.ui.graphics.Color

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
            focusedIndicatorColor = Color.Companion.Transparent,
            unfocusedIndicatorColor = Color.Companion.Transparent,
            disabledIndicatorColor = Color.Companion.Transparent,
            borderColor = Color(0xFFE0E0E0),
            errorIndicatorColor = Color.Companion.Transparent,
            errorContainerColor = Color(0xFFF7F7F7),
            errorTextColor = Color(0xFFF44336),
            errorBorderColor = Color(0xFFF44336),
            placeholderColor = Color(0xFFB0BEC5)
        )
    }
}