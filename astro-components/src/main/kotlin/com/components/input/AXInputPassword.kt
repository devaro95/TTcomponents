package com.components.input

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axcomponents.app.R
import com.components.text.AXErrorText
import com.components.text.AXHeaderText18
import com.theming.AXTheme
import com.theming.colors.AXInputColors
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

/**
 * `AXInputPassword` is a composable function that creates a password input field with customizable
 * properties. It provides a styled text field suitable for password entry, including features
 * such as a visibility toggle for showing/hiding the password, error state handling, and
 * customizable styling.
 *
 * @param modifier Modifier to apply to the outer `Column` wrapping the input field.
 *                 Use this to control padding, alignment, and other layout properties.
 * @param value The current text value of the input field. This is a two-way binding,
 *              so changes in the input field will update this value, and changes to
 *              this value will update the input field.
 * @param placeholder The placeholder text to display when the input field is empty.
 * @param minLines The minimum number of lines the input field should occupy. Defaults to 1.
 * @param suffix Optional text to display as a suffix within the input field.
 *               This is displayed using the `AXHeaderText18` composable.
 * @param errorText The error message to display below the input field when `isError` is true.
 * @param isError A boolean indicating whether the input field is in an error state.
 *                When true, the input field's border will be styled as an error, and the
 *                `errorText` will be displayed.
 * @param imeAction The IME action to be set for the keyboard. Defaults to `ImeAction.Unspecified`.
 * @param onChange Lambda that is invoked when the input field's text changes.
 *                 It provides the new text value as a `String`.
 *
 * Example usage:
 * @sample AXInputPasswordNewPreview
 *
 */
@Composable
fun AXInputPassword(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String? = null,
    minLines: Int = 1,
    suffix: String? = null,
    errorText: String = EMPTY_STRING,
    isError: Boolean = false,
    imeAction: ImeAction = ImeAction.Unspecified,
    colors: AXInputColors = AXInputColors.defaultColors,
    onChange: (String) -> Unit,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (isError) colors.errorBorderColor else colors.borderColor,
                    shape = RoundedCornerShape(8.dp)
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
                errorContainerColor = colors.errorContainerColor
            ),
            value = value,
            onValueChange = onChange,
            shape = CircleShape.copy(CornerSize(8.dp)),
            singleLine = minLines == 1,
            minLines = minLines,
            textStyle = MaterialTheme.typography.bodyMedium,
            label = placeholder?.let {
                {
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
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = imeAction
            ),
            suffix = suffix?.let {
                { AXHeaderText18(text = it) }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        if (passwordVisible) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            isError = isError
        )
        if (isError) {
            AXErrorText(
                modifier = Modifier.padding(top = 4.dp),
                text = errorText
            )
        }
    }
}

@Composable
@VROLightMultiDevicePreview
private fun AXInputPasswordNewPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        var passwordBasic by remember { mutableStateOf(EMPTY_STRING) }
        AXInputPassword(
            value = passwordBasic,
            placeholder = "Basic password",
            onChange = { passwordBasic = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        var passwordValue by remember { mutableStateOf("Example value") }
        AXInputPassword(
            value = passwordValue,
            placeholder = "Basic password",
            onChange = { passwordValue = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        var passwordError by remember { mutableStateOf(EMPTY_STRING) }
        AXInputPassword(
            value = passwordError,
            placeholder = "Password with error text",
            errorText = "Invalid password format",
            isError = true,
            onChange = { passwordError = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        var passwordError2 by remember { mutableStateOf(EMPTY_STRING) }
        AXInputPassword(
            value = passwordError2,
            placeholder = "Password with error",
            isError = true,
            onChange = { passwordError2 = it }
        )
    }
}
