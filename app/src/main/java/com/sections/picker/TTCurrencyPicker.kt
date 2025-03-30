package com.sections.picker

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.picker.TTCurrencyPicker
import com.components.picker.model.TTCurrencyItemData
import com.sections.Section

@Composable
fun TTCurrencyPickerSection() {
    val itemList = listOf(
        TTCurrencyItemData(id = 1, value = "USD", name = "US Dollar", symbol = "$"),
        TTCurrencyItemData(id = 2, value = "EUR", name = "Euro", symbol = "€"),
        TTCurrencyItemData(id = 3, value = "JPY", name = "Japanese Yen", symbol = "¥"),
        TTCurrencyItemData(id = 4, value = "GBP", name = "British Pound", symbol = "£"),
        TTCurrencyItemData(id = 5, value = "AUD", name = "Australian Dollar", symbol = "A$")
    )
    Column {
        Section(title = "TTCurrencyPicker no item selected") {
            TTCurrencyPicker(
                itemList = itemList,
                onClick = { }
            )
        }
        Section(title = "TTImagePicker item selected") {
            TTCurrencyPicker(
                itemList = itemList,
                itemSelected = itemList[1],
                onClick = { }
            )
        }
    }
}
