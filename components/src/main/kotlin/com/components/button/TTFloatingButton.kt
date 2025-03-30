package com.components.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theming.TTTheme
import com.theming.colors.TTButtonColors

/**
 * A customizable floating action button composable.
 *
 * This composable creates a floating action button (FAB) that can be customized with text,
 * enabled state, and color. The FAB's appearance changes based on its enabled state.
 *
 * @param modifier Modifier to be applied to the button.
 * @param text The text to display inside the button.
 * @param enabled Controls the enabled state of the button. When `false`, the button is disabled
 *        and not clickable.
 * @param color The background color of the button when it is enabled.
 * @param onClick The callback that is triggered when the button is clicked.
 *
 * Example usage:
 * @sample TTFloatingButtonPreview
 */
@Composable
fun TTFloatingButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    colors: TTButtonColors = TTTheme.colorScheme.buttonColors,
    onClick: () -> Unit,
) {
    FloatingActionButton(
        onClick = { if (enabled) onClick() },
        shape = RoundedCornerShape(24.dp),
        modifier = modifier.height(50.dp),
        containerColor = if (enabled) colors.floatingButtonBackground
        else colors.disabledFloatingButtonBackground
    ) {
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    color = if (enabled) colors.floatingButtonText
                    else colors.disabledFloatingButtonText
                )
            }
        }
    }
}

/**
 * Example usage of the TTFloatingButton composable.
 */
@Preview
@Composable
private fun TTFloatingButtonPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TTFloatingButton(text = "Example", onClick = {})
        TTFloatingButton(text = "Disabled", enabled = false, onClick = {})
        TTFloatingButton(text = "Example with long text", onClick = {})
    }
}