package com.components.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.input.TTInputType.DIGITS
import com.theming.colors.TTInputColors
import com.vro.constants.EMPTY_STRING

/**
 * A composable that provides a specialized text input field for currency values.
 *
 * This composable extends the functionality of [TTInput] to create a text input field
 * specifically designed for currency values. It restricts the input to numeric values,
 * displays a currency suffix, and offers customizable styling options.
 *
 * @param modifier Modifier to be applied to the currency input field.
 * @param value The current numeric value of the input field.
 * @param placeholder The placeholder text to display when the input field is empty.
 * @param startIcon The resource ID of an icon to display at the start of the input field.
 * @param maxLength The maximum number of digits allowed in the input field. If null, no limit is applied.
 * @param currency The currency symbol or code to display as a suffix (e.g., "€", "$", "USD").
 * @param colors Custom colors to be applied to the input field.
 * @param onChange A callback function to invoke when the text value of the input field changes.
 *
 * Example usage:
 * @sample TTInputCurrencyPreview
 */
@Composable
fun TTInputCurrency(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = EMPTY_STRING,
    startIcon: Int? = null,
    maxLength: Int? = null,
    currency: String,
    colors: TTInputColors = TTInputColors.defaultColors,
    onChange: (String) -> Unit,
) {
    TTInput(
        modifier = modifier,
        value = value,
        placeholder = placeholder,
        startIcon = startIcon,
        maxLength = maxLength,
        keyboardType = KeyboardType.NumberPassword,
        suffix = currency,
        ttInputType = DIGITS,
        colors = colors,
        onChange = onChange
    )
}

/**
 * Example usage of the TTInputCurrency composable.
 */
@Composable
@Preview
private fun TTInputCurrencyPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TTInputCurrency(
            value = EMPTY_STRING,
            placeholder = "Input",
            currency = "€",
            onChange = {}
        )
        TTInputCurrency(
            value = EMPTY_STRING,
            placeholder = "Input",
            currency = "€",
            onChange = {}
        )
        TTInputCurrency(
            value = "value",
            placeholder = "Input",
            currency = "€",
            onChange = {}
        )
        TTInputCurrency(
            value = EMPTY_STRING,
            placeholder = "Counter Input",
            currency = "€",
            onChange = {}
        )
    }
}
