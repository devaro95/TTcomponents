package com.components.input

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.axcomponents.app.R
import com.components.icon.AXIcon
import com.components.input.model.AXInputType
import com.components.input.model.AXInputType.FULL
import com.components.text.*
import com.theming.AXTheme
import com.theming.colors.AXInputColors
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

/**
 * A composable function that displays an old text input field.
 *
 * @deprecated This component is deprecated. Use [AXInput] instead.
 *
 * This component is an older implementation of a text input field with various options for customization.
 * It includes features such as a placeholder, start icon, character counter, and more.
 * However, it has been replaced by a newer, more flexible, and maintainable implementation: [AXInput].
 *
 * It is strongly recommended to migrate to [AXInput] for new development and consider updating existing usage as well.
 *
 * @param modifier The [Modifier] to be applied to the root of this composable.
 * @param value The current text value of the input field.
 * @param placeholder The placeholder text to display when the input field is empty.
 * @param startIcon An optional resource ID for an icon to be displayed at the start of the input field.
 * @param minLines The minimum number of lines to be displayed. Defaults to 1 (single-line).
 * @param maxLength The maximum number of characters allowed. If null, no limit is applied.
 * @param showCharCounter Whether to display the character counter. Defaults to `false`.
 * @param minLength The minimum number of characters required. Defaults to 0.
 * @param containerColor The background color of the input field. Defaults to transparent.
 * @param keyboardType The keyboard type to be used (e.g., Text, Number). Defaults to `KeyboardType.Text`.
 * @param suffix An optional text suffix to be displayed after the input text.
 * @param com.components.input.model.AXInputType An enum value to define the type of the input.
 * @param onChange A callback function invoked when the input text changes.
 *
 * Example usage (This is a deprecated component, consider using AXInput instead):
 * [AXInputOldPreview]
 *
 */
@Deprecated(
    "This component is deprecated. Use AXInput instead.",
    ReplaceWith("AXInput", "com.components.input.AXInput")
)
@Composable
fun AXInputOld(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = EMPTY_STRING,
    startIcon: Int? = null,
    minLines: Int = 1,
    maxLength: Int? = null,
    showCharCounter: Boolean = false,
    minLength: Int = INT_ZERO,
    containerColor: Color = Color.Transparent,
    keyboardType: KeyboardType = KeyboardType.Text,
    suffix: String? = null,
    inputType: AXInputType = FULL,
    colors: AXInputColors = AXTheme.colorScheme.inputColors,
    onChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = colors.focusedContainerColor,
                unfocusedContainerColor = colors.unfocusedContainerColor,
                disabledContainerColor = colors.disabledContainerColor,
                focusedBorderColor = colors.borderColor,
                unfocusedBorderColor = colors.borderColor
            ),
            value = value,
            onValueChange = {
                if (inputType == FULL || it.isDigitsOnly()) {
                    maxLength?.let { maxLength ->
                        if (it.length <= maxLength) onChange.invoke(it)
                    } ?: onChange.invoke(it)
                }
            },
            shape = CircleShape.copy(CornerSize(8.dp)),
            leadingIcon = startIcon?.let {
                {
                    AXIcon(iconRes = it)
                }
            },
            singleLine = minLines == 1,
            minLines = minLines,
            textStyle = MaterialTheme.typography.bodyMedium,
            label = {
                Text(
                    text = placeholder,
                    maxLines = 1,
                    style = TextStyle(
                        color = AXTheme.colorScheme.primaryColor,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.main_font_medium))
                    ),
                    overflow = TextOverflow.Ellipsis,
                    color = colors.placeholderColor
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            suffix = suffix?.let {
                { AXHeaderText18(text = it) }
            }
        )
        if (showCharCounter) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                if (value.length - minLength < INT_ZERO) {
                    AXErrorText(text = (value.length - minLength).toString())
                    AXBodyText14Bold(text = "/$maxLength")
                } else {
                    AXBodyText14(
                        text = (value.length - minLength).toString() + "/" + maxLength.toString(),
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun AXInputOldPreview() {
    Column {
        AXInputOld(
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        AXInputOld(
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        AXInputOld(
            value = "value",
            placeholder = "Input",
            onChange = {}
        )
        AXInputOld(
            value = EMPTY_STRING,
            minLength = 10,
            maxLength = 100,
            placeholder = "Counter Input",
            onChange = {}
        )
    }
}