package com.components.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.components.icon.TTIcon
import com.components.text.AXHeaderText14
import com.theming.TTTheme
import com.theming.colors.TTButtonColors
import com.ttcomponents.app.R
import com.vro.constants.EMPTY_STRING

/**
 * A customizable square button with an icon and optional text.
 *
 * This composable creates a square button that displays an icon and can optionally include text.
 * It provides customization options for the icon, text, padding, background color, and content color.
 * The button is implemented using an `ElevatedCard` for a raised appearance.
 *
 * @param modifier Modifier to be applied to the button.
 * @param contentModifier Modifier to be applied to the content inside the button.
 * @param iconRes The resource ID of the icon to display.
 * @param onClick The callback to be invoked when the button is clicked.
 * @param text The text to display alongside the icon (optional). Defaults to an empty string.
 * @param iconPadding The padding around the icon. Defaults to 8.dp.
 * @param iconSize The size of the icon. Defaults to 18.dp.
 * @param backgroundColor The background color of the button. Defaults to [Background].
 * @param contentColor The color of the icon and text. If null, the default [Primary] color is used.
 *
 * Example usage:
 * @sample TTButtonIconSquarePreview
 * @deprecated This composable is deprecated. Use [AXButtonIconSquare] instead for better performance
 * and more customization options.
 */
@Composable
fun TTButtonIconSquare(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
    iconRes: Int,
    onClick: () -> Unit = {},
    text: String = EMPTY_STRING,
    iconPadding: Dp = 8.dp,
    iconSize: Dp = 18.dp,
    colors: TTButtonColors = TTTheme.colorScheme.buttonColors
) {
    ElevatedCard(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = colors.buttonBackground
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = contentModifier.padding(horizontal = 4.dp)
        ) {
            if (text.isNotEmpty()) {
                AXHeaderText14(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .padding(vertical = 8.dp),
                    text = text,
                    color = colors.buttonText
                )
            }
            TTIcon(
                modifier = Modifier.padding(iconPadding),
                iconRes = iconRes,
                size = iconSize,
                onClick = onClick,
                tint = colors.buttonText
            )
        }
    }
}

/**
 * Example usage of the TTButtonIconSquare composable.
 */
@Preview
@Composable
fun TTButtonIconSquarePreview() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TTButtonIconSquare(
            iconRes = R.drawable.ic_like_empty,
            onClick = {}
        )
        TTButtonIconSquare(
            iconRes = R.drawable.ic_like_empty,
            onClick = {},
            text = "10.3M"
        )
        TTButtonIconSquare(
            modifier = Modifier.width(150.dp),
            iconRes = R.drawable.ic_like_empty,
            onClick = {},
            text = "Like"
        )
    }
}
