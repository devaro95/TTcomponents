package com.components.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theming.TTTheme
import com.theming.colors.TTButtonColors
import com.ttcomponents.app.R

/**
 * A composable button that displays a save icon within a square button.
 *
 * This composable provides a convenient way to create a button specifically designed for a "save" action.
 * It utilizes the `TTButtonIconSquare` composable to render a square button containing a save icon.
 *
 * @param onClick The callback to be invoked when the button is clicked.
 * @param modifier Modifier to be applied to the button.
 *
 * Example usage:
 * @sample TTButtonSavePreview
 */
@Composable
fun TTButtonSave(
    modifier: Modifier = Modifier,
    colors: TTButtonColors = TTTheme.colorScheme.buttonColors,
    onClick: () -> Unit,
) {
    Column(modifier = Modifier.padding(start = 6.dp)) {
        TTButtonIconSquare(
            iconRes = R.drawable.ic_save_section,
            onClick = onClick,
            colors = colors
        )
    }
}

/**
 * Example usage of the TTButtonSave composable.
 */
@Preview
@Composable
private fun TTButtonSavePreview() {
    TTButtonSave(onClick = {})
}