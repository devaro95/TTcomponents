package com.components.input

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
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
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

/**
 * A composable that displays a customizable text input field.
 *
 * This composable provides a text input field with various customization options, such as
 * placeholder text, start icon, character counter, error state, and more.
 *
 * @param modifier Modifier to be applied to the input field.
 * @param value The current text value of the input field.
 * @param placeholder The placeholder text to display when the input field is empty.
 * @param startIcon The resource ID of an icon to display at the start of the input field.
 * @param minLines The minimum number of lines the input field should occupy. Defaults to 1 (single line).
 * @param maxLength The maximum number of characters allowed in the input field. If null, no limit is applied.
 * @param showCharCounter Determines whether to display a character counter below the input field.
 * @param minLength The minimum number of characters required in the input field.
 * @param keyboardType The type of keyboard to display (e.g., text, number). Defaults to [KeyboardType.Text].
 * @param suffix Text to display at the end of the input field.
 * @param com.components.input.model.AXInputType The type of input allowed (e.g., [com.components.input.model.AXInputType.FULL] for any input or digits only).
 * @param errorText Text to display below the input field when it is in an error state.
 * @param isError Determines whether the input field is in an error state.
 * @param imeAction The IME action to display on the keyboard (e.g., done, next). Defaults to [ImeAction.Unspecified].
 * @param showBorder Determines whether to display a border around the input field.
 * @param colors Custom colors to be applied to the input field. Allows for styling beyond the default colors.
 * @param onChange A callback to invoke when the text value of the input field changes.
 *
 * Example usage:
 * @sample AXInputPreview
 */
@Composable
fun AXInput(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String? = null,
    startIcon: Int? = null,
    minLines: Int = 1,
    maxLength: Int? = null,
    showCharCounter: Boolean = false,
    minLength: Int = INT_ZERO,
    keyboardType: KeyboardType = KeyboardType.Text,
    suffix: String? = null,
    ttInputType: AXInputType = FULL,
    errorText: String = EMPTY_STRING,
    isError: Boolean = false,
    imeAction: ImeAction = ImeAction.Unspecified,
    showBorder: Boolean = true,
    colors: AXInputColors = AXTheme.colorScheme.inputColors,
    onChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (showBorder) Modifier.border(
                        width = 1.dp,
                        color = if (isError) colors.errorBorderColor else colors.borderColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                    else Modifier
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colors.focusedContainerColor,
                unfocusedContainerColor = colors.unfocusedContainerColor,
                disabledContainerColor = colors.disabledContainerColor,
                focusedIndicatorColor = colors.focusedIndicatorColor,
                unfocusedIndicatorColor = colors.unfocusedIndicatorColor,
                disabledIndicatorColor = colors.disabledIndicatorColor,
                errorIndicatorColor = colors.errorIndicatorColor,
                errorTextColor = colors.errorTextColor,
                errorContainerColor = colors.errorContainerColor,
            ),
            value = value,
            onValueChange = {
                if (ttInputType == FULL || it.isDigitsOnly()) {
                    maxLength?.let { maxLength ->
                        if (it.length <= maxLength) onChange.invoke(it)
                    } ?: onChange.invoke(it)
                }
            },
            shape = CircleShape.copy(CornerSize(8.dp)),
            leadingIcon = startIcon?.let {
                {
                    AXIcon(
                        iconRes = it,
                        size = 16.dp
                    )
                }
            },
            singleLine = minLines == 1,
            minLines = minLines,
            textStyle = MaterialTheme.typography.bodyMedium,
            label = placeholder?.let {
                {
                    Text(
                        text = placeholder,
                        maxLines = 1,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.main_font_medium))
                        ),
                        overflow = TextOverflow.Ellipsis,
                        color = colors.placeholderColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            suffix = suffix?.let {
                { AXHeaderText18(text = it) }
            },
            isError = isError
        )
        if (showCharCounter) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                if (value.length - minLength < INT_ZERO) {
                    AXErrorText(text = (value.length - minLength).toString())
                    AXLegendText(text = "/${maxLength}")
                } else {
                    AXLegendText(
                        text = (value.length - minLength).toString() + "/" + maxLength.toString(),
                    )
                }
            }
        }
        if (isError) {
            AXErrorText(
                modifier = Modifier.padding(top = 4.dp),
                text = errorText,
            )
        }
    }
}

/**
 * Example usage of the AXInput composable.
 */
@Composable
@VROLightMultiDevicePreview
private fun AXInputPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        AXInput(
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        AXInput(
            value = "Value",
            onChange = {}
        )
        AXInput(
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        AXInput(
            value = "value",
            placeholder = "Input",
            onChange = {}
        )
        AXInput(
            value = EMPTY_STRING,
            minLength = 10,
            maxLength = 100,
            placeholder = "Counter Input",
            showCharCounter = true,
            onChange = {}
        )
        AXInput(
            value = EMPTY_STRING,
            minLength = 10,
            maxLength = 100,
            placeholder = "Counter Input",
            onChange = {},
            isError = true,
            errorText = "Error"
        )
    }
}
