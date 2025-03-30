package com.theming

import androidx.compose.ui.graphics.Color

data class TTSocialStatsColors(
    val likeIconColor: Color,
    val likeTextColor: Color,
    val unlikeIconColor: Color,
    val unlikeTextColor: Color,
    val saveIconColor: Color,
    val saveTextColor: Color,
    val unsaveIconColor: Color,
    val unsaveTextColor: Color,
) {

    companion object {
        val defaultColors = TTSocialStatsColors(
            likeIconColor = Color(0xFF333333),
            likeTextColor = Color(0xFF333333),
            unlikeIconColor = Color(0xFF333333),
            unlikeTextColor = Color(0xFF333333),
            saveIconColor = Color(0xFF333333),
            saveTextColor = Color(0xFF333333),
            unsaveIconColor = Color(0xFF333333),
            unsaveTextColor = Color(0xFF333333)
        )
    }
}