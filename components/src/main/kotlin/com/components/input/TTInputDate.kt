package com.components.input

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.icon.TTIcon
import com.theming.colors.TTInputColors
import com.theming.TTTheme
import com.ttcomponents.app.R

/**
 * A composable function that displays a dual-input date field.
 *
 * This component is designed to allow users to select two dates, typically a departure and an arrival date.
 * It provides a visually distinct layout with two clickable sections, separated by a vertical divider.
 *
 * @param modifier The [Modifier] to be applied to the root of this composable.
 * @param firstValue The string value for the first date input (e.g., departure date). Can be null.
 * @param secondValue The string value for the second date input (e.g., arrival date). Can be null.
 * @param onFirstClick A callback function that is invoked when the first date input area is clicked.
 * @param onSecondClick A callback function that is invoked when the second date input area is clicked.
 *
 * The component is structured as a row containing two columns. Each column displays a `TTInputDateTextField` and is
 * clickable. The visual style includes rounded corners, a background color, and a border.
 *
 * Example usage:
 * @sample TTInputDateDatePreview
 *
 **/
@Composable
fun TTInputDate(
    modifier: Modifier = Modifier,
    firstValue: String? = null,
    secondValue: String? = null,
    isError: Boolean = false,
    colors: TTInputColors = TTInputColors.defaultColors,
    onFirstClick: () -> Unit,
    onSecondClick: () -> Unit,
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(8.dp))
            .background(colors.focusedContainerColor)
            .border(
                1.dp, if (isError) colors.errorBorderColor
                else colors.borderColor,
                RoundedCornerShape(8.dp)
            )
    ) {
        Column(
            Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onFirstClick,
                )
                .fillMaxWidth()
                .weight(1f)
        ) {
            TTInputDateTextField(
                value = firstValue.orEmpty(),
                placeholder = stringResource(R.string.input_date_departure),
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    bottomStart = 8.dp
                )
            )
        }
        VerticalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            color = TTTheme.colorScheme.primaryColor
        )
        Column(
            Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onSecondClick,
                )
                .fillMaxWidth()
                .weight(1f)
        ) {
            TTInputDateTextField(
                value = secondValue.orEmpty(),
                placeholder = stringResource(R.string.input_date_arrival),
                shape = RoundedCornerShape(
                    topEnd = 8.dp,
                    bottomEnd = 8.dp
                ),
                colors = colors
            )
        }
    }
}

/**
 * A private composable function that represents a single text field for the `TTInputDate` component.
 *
 * This component is designed to display a non-editable text field with a placeholder, intended for showing date values.
 * It is typically used within the `TTInputDate` composable to render each date input section.
 *
 * @param value The current text value to be displayed in the text field.
 * @param placeholder The placeholder text to display when the `value` is empty.
 * @param shape The [Shape] to be applied to the text field's background and border.
 * @param startIcon Optional resource ID for an icon to be displayed at the start of the text field.
 *
 * This component uses Material Design's `TextField` and configures it to be non-editable (disabled)
 * and visually distinct with a custom shape and colors.
 * The appearance of the placeholder text and the main text are controlled via the `label` and `textStyle` parameters.
 *
 * Example usage (typically within `TTInputDate`):
 *
 *
 * */
@Composable
private fun TTInputDateTextField(
    value: String,
    placeholder: String,
    shape: Shape,
    startIcon: Int? = null,
    colors: TTInputColors = TTInputColors.defaultColors,
) {
    TextField(
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colors.focusedContainerColor,
            unfocusedContainerColor = colors.unfocusedContainerColor,
            disabledContainerColor = colors.disabledContainerColor,
            focusedIndicatorColor = colors.focusedIndicatorColor,
            unfocusedIndicatorColor = colors.unfocusedIndicatorColor,
            disabledIndicatorColor = colors.disabledIndicatorColor
        ),
        enabled = false,
        value = value,
        onValueChange = { },
        shape = shape,
        leadingIcon = startIcon?.let { { TTIcon(iconRes = it) } },
        singleLine = true,
        maxLines = 1,
        minLines = 1,
        textStyle = MaterialTheme.typography.headlineMedium,
        label = {
            Text(
                text = placeholder,
                minLines = 1,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                color = colors.placeholderColor
            )
        }
    )
}

@Composable
@Preview
fun TTInputDateDatePreview() {
    Column {
        TTInputDate(
            firstValue = "15/10/2024",
            secondValue = "20/10/2024",
            onFirstClick = { println("First date clicked (Example 1)") },
            onSecondClick = { println("Second date clicked (Example 1)") }
        )
        TTInputDate(
            modifier = Modifier.padding(top = 16.dp),
            firstValue = null,
            secondValue = "25/10/2024",
            onFirstClick = { println("First date clicked (Example 2)") },
            onSecondClick = { println("Second date clicked (Example 2)") }
        )
        TTInputDate(
            modifier = Modifier.padding(top = 16.dp),
            firstValue = "10/10/2024",
            secondValue = null,
            onFirstClick = { println("First date clicked (Example 3)") },
            onSecondClick = { println("Second date clicked (Example 3)") }
        )
        TTInputDate(
            modifier = Modifier.padding(top = 16.dp),
            firstValue = null,
            secondValue = null,
            onFirstClick = { println("First date clicked (Example 4)") },
            onSecondClick = { println("Second date clicked (Example 4)") }
        )
        TTInputDate(
            modifier = Modifier.padding(top = 16.dp),
            firstValue = "01/01/2024",
            secondValue = "02/01/2024",
            isError = true,
            onFirstClick = { println("First date clicked (Example 5)") },
            onSecondClick = { println("Second date clicked (Example 5)") }
        )
    }
}