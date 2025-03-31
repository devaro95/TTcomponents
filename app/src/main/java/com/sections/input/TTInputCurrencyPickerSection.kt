package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.components.input.AXInputCurrencyPicker
import com.components.input.AXInputMenuDropdownItemData
import com.sections.Section

@Composable
fun AXInputCurrencyPickerSection() {
    Column {
        Section(title = "AXInputCurrencyPicker with empty value") {
            val itemList = listOf(
                AXInputMenuDropdownItemData(value = 1, "0-10"),
                AXInputMenuDropdownItemData(value = 2, "10-20"),
                AXInputMenuDropdownItemData(value = 3, "20-30"),
                AXInputMenuDropdownItemData(value = 4, "+40")
            )
            var selected by remember { mutableStateOf<AXInputMenuDropdownItemData?>(null) }
            AXInputCurrencyPicker(
                selected = selected,
                placeholder = "Precio",
                currency = "USD",
                items = itemList,
                symbol = "$",
                onCurrencyClick = {},
                onPriceSelected = {
                    selected = it
                }
            )
        }
        Section(title = "AXInputCurrencyPicker with value") {
            val itemList = listOf(
                AXInputMenuDropdownItemData(value = 0, "0"),
                AXInputMenuDropdownItemData(value = 1, "10"),
                AXInputMenuDropdownItemData(value = 2, "20"),
                AXInputMenuDropdownItemData(value = 3, "30"),
                AXInputMenuDropdownItemData(value = 4, "+40")
            )
            var selected by remember { mutableStateOf(itemList[0]) }
            AXInputCurrencyPicker(
                selected = selected,
                placeholder = "Precio",
                currency = "EUR",
                items = itemList,
                symbol = "€",
                onCurrencyClick = {},
                onPriceSelected = {
                    selected = it
                }
            )
        }
    }
}
