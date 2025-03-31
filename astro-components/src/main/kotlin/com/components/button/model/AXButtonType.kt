package com.components.button.model

import androidx.compose.ui.unit.*

/**
 * Represents the different types of buttons available in the AXButton composable.
 * Each type has a predefined height and font size.
 *
 * @property height The height of the button.
 * @property fontSize The font size of the text inside the button.
 */

enum class AXButtonType(
    val height: Dp,
    val fontSize: TextUnit,
) {

    /**
     * Represents a normal sized button.
     */
    NORMAL(
        height = 51.dp,
        fontSize = 16.sp
    ),

    /**
     * Represents a small sized button.
     */
    SMALL(
        height = 41.dp,
        fontSize = 14.sp
    ),

    /**
     * Represents a large sized button.
     */
    EXTRA_SMALL(
        height = 35.dp,
        fontSize = 12.sp
    ),

    /**
     * Represents a large sized button.
     */
    LARGE(72.dp, 18.sp)
}