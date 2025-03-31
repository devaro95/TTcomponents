package com.components.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.button.model.AXButtonType
import com.theming.AXTheme
import com.theming.colors.AXButtonColors

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
 * @sample AXButtonPreview
 */

@Composable
fun AXButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    buttonType: AXButtonType = AXButtonType.NORMAL,
    colors: AXButtonColors = AXTheme.colorScheme.buttonColors,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.height(buttonType.height),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.buttonBackground,
            disabledContainerColor = colors.disabledButtonBackground
        ),
        shape = CircleShape.copy(CornerSize(24.dp)),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = buttonType.fontSize,
            color = if (enabled) colors.buttonText
            else colors.disabledButtonText,
            modifier = Modifier.alpha(if (enabled) 1f else 0.9f)
        )
    }
}

/**
 * Example of how to use the AXButton composable.
 */
@Composable
@Preview
private fun AXButtonPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AXButton(text = "Normal Button", onClick = {})
        AXButton(text = "Small Button", buttonType = AXButtonType.SMALL, onClick = {})
        AXButton(text = "Large Button", buttonType = AXButtonType.LARGE, onClick = {})
        AXButton(text = "Disabled Button", enabled = false, onClick = {})
    }
}