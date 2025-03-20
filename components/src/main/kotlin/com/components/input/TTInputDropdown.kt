package com.components.input

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.icon.TTIcon
import com.theming.TTColors.TTInputColors
import com.theming.TTTheme
import com.ttcomponents.app.R
import com.vro.constants.EMPTY_STRING

/**
 * A composable function that displays a dropdown input field.
 *
 * This component allows the user to select an item from a predefined list of items.
 * It presents a styled text field that, when clicked, triggers an action, usually to show a list of selectable options.
 *
 * @param modifier The [Modifier] to be applied to the root of this composable.
 * @param items The list of [TTInputDropdownItemData] representing the selectable items in the dropdown.
 * @param placeholder The placeholder text to display when no item is selected.
 * @param selectedItem The currently selected item's text. If provided, this will be displayed in the field.
 * @param selectedPosition The index of the currently selected item in the `items` list. If provided, the corresponding item's text will be displayed.
 * @param showBorder Determines whether to display a border around the dropdown. Defaults to `true`.
 * @param isError Indicates if the dropdown is in an error state. If `true`, the border color will change to reflect the error.
 * @param inputColors The [TTInputColors] to customize the colors of the dropdown.
 * @param onClick An optional callback function that is invoked when the dropdown is clicked. Typically used to display a list of options.
 *
 * The dropdown is styled with a rounded corner shape and can optionally display a border. It also includes
 * a placeholder text, an optional selected item text, and a rotated icon to indicate that it is a dropdown.
 * The `selectedItem` and `selectedPosition` parameters are mutually exclusive; if both are provided, `selectedPosition` will take precedence.
 *
 * Example usage:
 * @sample TTInputDropdownPreview
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTInputDropdown(
    modifier: Modifier = Modifier,
    items: List<TTInputDropdownItemData>,
    placeholder: String = EMPTY_STRING,
    selectedItem: String? = null,
    selectedPosition: Int? = null,
    showBorder: Boolean = true,
    isError: Boolean = false,
    inputColors: TTInputColors = TTInputColors.defaultColors,
    onClick: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .height(56.dp)
            .then(
                if (showBorder) Modifier.border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = if (isError) inputColors.errorBorderColor else inputColors.borderColor
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                else Modifier
            )
            .clip(RoundedCornerShape(10.dp))
            .background(inputColors.focusedContainerColor)
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
                Text(
                    text = placeholder,
                    maxLines = 1,
                    style = TextStyle(
                        color = TTTheme.colorScheme.primaryColor,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.main_font_medium))
                    ),
                    overflow = TextOverflow.Ellipsis,
                    color = inputColors.placeholderColor
                )
                if (selectedItem != null || selectedPosition != null) {
                    Text(
                        text = selectedPosition?.let {
                            items[selectedPosition].text
                        } ?: run {
                            selectedItem ?: placeholder
                        },
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                    )
                }
            }
            Column(modifier = Modifier.padding(end = 16.dp)) {
                TTIcon(
                    iconRes = R.drawable.ic_back,
                    modifier = Modifier.rotate(-90f),
                    onClick = { onClick?.invoke() },
                    tint = inputColors.placeholderColor
                )
            }
        }
    }
}

data class TTInputDropdownItemData(
    val text: String,
)

@Composable
@Preview
private fun TTInputDropdownPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TTInputDropdown(
            items = listOf(
                TTInputDropdownItemData("One"),
                TTInputDropdownItemData("Two"),
                TTInputDropdownItemData("Three")
            ),
            placeholder = EMPTY_STRING,
            onClick = { println("Dropdown clicked (Example 7)") }
        )
        TTInputDropdown(
            items = listOf(
                TTInputDropdownItemData("Option 1"),
                TTInputDropdownItemData("Option 2"),
                TTInputDropdownItemData("Option 3")
            ),
            placeholder = "Select an option",
            onClick = { println("Dropdown clicked (Example 1)") }
        )
        TTInputDropdown(
            items = listOf(
                TTInputDropdownItemData("January"),
                TTInputDropdownItemData("February"),
                TTInputDropdownItemData("March")
            ),
            placeholder = "Month",
            selectedPosition = 0,
            onClick = { println("Dropdown clicked (Example 3)") }
        )
        TTInputDropdown(
            items = listOf(
                TTInputDropdownItemData("Error 1"),
                TTInputDropdownItemData("Error 2"),
                TTInputDropdownItemData("Error 3")
            ),
            placeholder = "Error",
            isError = true,
            onClick = { println("Dropdown clicked (Example 5)") }
        )
    }
}