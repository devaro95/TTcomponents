package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.components.input.TTInputCurrency
import com.ttcomponents.app.R
import com.utils.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun TTInputCurrencySection() {
    Column {
        Section(title = "TTInputCurrency with empty value") {
            var value by remember { mutableStateOf(EMPTY_STRING) }
            TTInputCurrency(
                value = value,
                placeholder = "Input",
                currency = "€",
                onChange = { value = it }
            )
        }
        Section(title = "TTInputCurrency with value") {
            var value by remember { mutableStateOf("150") }
            TTInputCurrency(
                value = value,
                placeholder = "Input",
                currency = "$",
                onChange = { value = it }
            )
        }
        Section(title = "TTInputCurrency with value") {
            var value by remember { mutableStateOf("150") }
            TTInputCurrency(
                value = value,
                placeholder = "Input",
                currency = "€",
                onChange = { value = it }
            )
        }
        Section(title = "TTInputCurrency with start icon") {
            var value by remember { mutableStateOf("150") }
            TTInputCurrency(
                value = value,
                placeholder = "Counter Input",
                currency = "€",
                startIcon = R.drawable.ic_guides,
                onChange = { value = it }
            )
        }
    }
}