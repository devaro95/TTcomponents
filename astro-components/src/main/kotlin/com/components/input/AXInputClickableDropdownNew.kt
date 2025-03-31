package com.components.input

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.axcomponents.app.R
import com.components.icon.AXIcon
import com.components.text.AXErrorText
import com.theming.colors.AXInputColors
import com.vro.constants.EMPTY_STRING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AXInputClickableDropdownNew(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String? = null,
    startIcon: Int? = null,
    errorText: String = EMPTY_STRING,
    isError: Boolean = false,
    showBorder: Boolean = true,
    colors: AXInputColors = AXInputColors.defaultColors,
    onClick: () -> Unit,
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
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onClick
                ),
            readOnly = true,
            enabled = false,
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
            onValueChange = {},
            shape = CircleShape.copy(CornerSize(8.dp)),
            leadingIcon = startIcon?.let {
                {
                    AXIcon(
                        iconRes = it,
                        size = 16.dp
                    )
                }
            },
            trailingIcon = {
                AXIcon(
                    iconRes = R.drawable.ic_back,
                    modifier = Modifier.rotate(-90f),
                    onClick = { onClick.invoke() },
                    tint = colors.legendColor
                )
            },
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
            isError = isError
        )
        if (isError) {
            AXErrorText(
                modifier = Modifier.padding(top = 4.dp),
                text = errorText,
            )
        }
    }
}

/**
 * Example usage of the AXInputClickableDropdown composable.
 */
@Composable
@Preview()
private fun AXInputClickableDropdownNewPreview() {
    AXInputClickableDropdownNew(
        value = "EUR",
        onClick = {}
    )
}