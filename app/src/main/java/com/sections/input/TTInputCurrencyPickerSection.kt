package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.components.input.TTInputCurrencyPicker
import com.components.input.TTInputMenuDropdownItemData
import com.sections.Section

@Composable
fun TTInputCurrencyPickerSection() {
    Column {
        Section(title = "TTInputCurrencyPicker with empty value") {
            val itemList = listOf(
                TTInputMenuDropdownItemData(value = 1, "0-10"),
                TTInputMenuDropdownItemData(value = 2, "10-20"),
                TTInputMenuDropdownItemData(value = 3, "20-30"),
                TTInputMenuDropdownItemData(value = 4, "+40")
            )
            var selected by remember { mutableStateOf<TTInputMenuDropdownItemData?>(null) }
            TTInputCurrencyPicker(
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
        Section(title = "TTInputCurrencyPicker with value") {
            val itemList = listOf(
                TTInputMenuDropdownItemData(value = 0, "0"),
                TTInputMenuDropdownItemData(value = 1, "10"),
                TTInputMenuDropdownItemData(value = 2, "20"),
                TTInputMenuDropdownItemData(value = 3, "30"),
                TTInputMenuDropdownItemData(value = 4, "+40")
            )
            var selected by remember { mutableStateOf(itemList[0]) }
            TTInputCurrencyPicker(
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
