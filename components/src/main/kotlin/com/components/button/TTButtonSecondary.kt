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
import androidx.compose.ui.unit.sp
import com.theming.TTTheme

/**
 * A secondary style button composable.
 *
 * This composable creates a button with a secondary style, characterized by a transparent background
 * and a colored border. The button's appearance changes based on its enabled state.
 *
 * @param modifier Modifier to be applied to the button.
 * @param text The text to display inside the button.
 * @param enabled Controls the enabled state of the button. When `false`, the button is disabled
 *        and not clickable. Defaults to `true`.
 * @param onClick The callback that is triggered when the button is clicked.
 *
 * Example usage:
 * @sample TTButtonSecondaryPreview
 */
@Composable
fun TTButtonSecondary(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier
            .height(51.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = TTTheme.colorScheme.buttonBackground,
            disabledContainerColor = TTTheme.colorScheme.disabledButtonBackground
        ),
        shape = CircleShape.copy(CornerSize(24.dp)),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = if (enabled) TTTheme.colorScheme.buttonText
            else TTTheme.colorScheme.disabledButtonText,
            modifier = Modifier.alpha(if (enabled) 1f else 0.5f)
        )
    }
}

/**
 * Example usage of the TTButtonSecondary composable.
 */
@Preview
@Composable
fun TTButtonSecondaryPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TTButtonSecondary(text = "Example", onClick = {})
        TTButtonSecondary(text = "Disabled", enabled = false, onClick = {})
        TTButtonSecondary(text = "Example with long text", onClick = {})
    }
}