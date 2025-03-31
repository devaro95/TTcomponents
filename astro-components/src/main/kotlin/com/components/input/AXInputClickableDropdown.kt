package com.components.input

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.axcomponents.app.R
import com.components.icon.AXIcon
import com.components.text.AXHeaderText14
import com.theming.colors.AXInputColors
import com.vro.constants.EMPTY_STRING

/**
 * A composable that displays a clickable dropdown input field.
 *
 * This composable provides a stylized input field that, when clicked, triggers an action,
 * typically used to display a dropdown menu or a selection dialog. It includes an optional
 * border, custom colors, and an indicator icon.
 *
 * @param modifier Modifier to be applied to the dropdown input field.
 * @param value The text value to display within the dropdown input field.
 * @param showBorder Determines whether to display a border around the input field.
 * @param colors Custom colors to be applied to the input field.
 * @param onClick An optional callback to be invoked when the dropdown input field is clicked.
 *
 * Example usage:
 * @sample AXInputClickableDropdownPreview
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AXInputClickableDropdown(
    modifier: Modifier = Modifier,
    value: String = EMPTY_STRING,
    showBorder: Boolean = true,
    colors: AXInputColors = AXInputColors.defaultColors,
    onClick: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .height(56.dp)
            .then(
                if (showBorder) Modifier.border(
                    border = BorderStroke(1.dp, colors.borderColor),
                    shape = RoundedCornerShape(10.dp)
                )
                else Modifier
            )
            .clip(RoundedCornerShape(10.dp))
            .background(colors.focusedContainerColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick?.invoke() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                AXHeaderText14(text = value)
            }
            Column(modifier = Modifier.padding(end = 16.dp)) {
                AXIcon(
                    iconRes = R.drawable.ic_back,
                    modifier = Modifier.rotate(-90f),
                    onClick = { onClick?.invoke() },
                    tint = colors.legendColor
                )
            }
        }
    }
}

/**
 * Example usage of the AXInputClickableDropdown composable.
 */
@Composable
@Preview()
private fun AXInputClickableDropdownPreview() {
    AXInputClickableDropdown(
        value = "EUR"
    )
}