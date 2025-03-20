package com.components.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.theming.TTTheme

/**
 * A customizable button composable that allows for different button types and states.
 *
 * This composable creates a button with a circular shape and customizable text,
 * color, and behavior. It supports different types of buttons through the [ButtonType]
 * enum, and allows the button to be enabled or disabled.
 *
 * @param modifier Modifier to apply to the button.
 * @param text The text to display inside the button.
 * @param enabled Controls the enabled state of the button. When `false`, the button is
 *        disabled and not clickable. Defaults to `true`.
 * @param buttonType The type of the button, determining its size and text size.
 *        Defaults to [ButtonType.NORMAL].
 * @param onClick The callback that is triggered when the button is clicked.
 *
 * Example usage:
 * @sample TTButtonPreview
 */

@Composable
fun TTButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    buttonType: ButtonType = ButtonType.NORMAL,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.height(buttonType.height),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = TTTheme.colorScheme.buttonBackground,
            disabledContainerColor = TTTheme.colorScheme.disabledButtonBackground
        ),
        shape = CircleShape.copy(CornerSize(24.dp)),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = buttonType.fontSize,
            color = if (enabled) TTTheme.colorScheme.buttonText
            else TTTheme.colorScheme.disabledButtonText,
            modifier = Modifier.alpha(if (enabled) 1f else 0.9f)
        )
    }
}

/**
 * Represents the different types of buttons available in the TTButton composable.
 * Each type has a predefined height and font size.
 *
 * @property height The height of the button.
 * @property fontSize The font size of the text inside the button.
 */

enum class ButtonType(
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

/**
 * Example of how to use the TTButton composable.
 */
@Composable
@Preview
private fun TTButtonPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TTButton(text = "Normal Button", onClick = {})
        TTButton(text = "Small Button", buttonType = ButtonType.SMALL, onClick = {})
        TTButton(text = "Large Button", buttonType = ButtonType.LARGE, onClick = {})
        TTButton(text = "Disabled Button", enabled = false, onClick = {})
    }
}