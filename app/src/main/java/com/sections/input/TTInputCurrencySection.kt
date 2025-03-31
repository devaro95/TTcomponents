package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.components.input.AXInputCurrency
import com.ttcomponents.app.R
import com.sections.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun AXInputCurrencySection() {
    Column {
        Section(title = "AXInputCurrency with empty value") {
            var value by remember { mutableStateOf(EMPTY_STRING) }
            AXInputCurrency(
                value = value,
                placeholder = "Input",
                currency = "€",
                onChange = { value = it }
            )
        }
        Section(title = "AXInputCurrency with value") {
            var value by remember { mutableStateOf("150") }
            AXInputCurrency(
                value = value,
                placeholder = "Input",
                currency = "$",
                onChange = { value = it }
            )
        }
        Section(title = "AXInputCurrency with value") {
            var value by remember { mutableStateOf("150") }
            AXInputCurrency(
                value = value,
                placeholder = "Input",
                currency = "€",
                onChange = { value = it }
            )
        }
        Section(title = "AXInputCurrency with start icon") {
            var value by remember { mutableStateOf("150") }
            AXInputCurrency(
                value = value,
                placeholder = "Counter Input",
                currency = "€",
                startIcon = R.drawable.ic_guides,
                onChange = { value = it }
            )
        }
    }
}
