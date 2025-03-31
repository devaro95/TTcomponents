package com.components.picker

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.input.key.Key.Companion.U
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.picker.model.TTCurrencyItemData
import com.components.text.*
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

private const val Separator = " - "

/**
 * `TTCurrencyPicker` is a composable function that creates a picker for selecting a currency.
 *
 * This component displays a vertically arranged list of currency items, where each item can be
 * selected. It provides a clear visual indication of the currently selected item.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the list.
 *                 Use this to control layout properties, such as padding, size, and alignment.
 * @param itemList A list of `TTCurrencyItemData` objects representing the currency items to display
 *                 in the picker.
 * @param itemSelected An optional `TTCurrencyItemData` object representing the currently selected
 *                     currency item. If `null`, no item is initially selected.
 * @param onClick Lambda that is invoked when a currency item is clicked. It provides the `id` of
 *                the clicked item.
 *
 * Example Usage:
 * @sample TTCurrencyPickerPreview
 *
 */
@Composable
fun TTCurrencyPicker(
    modifier: Modifier = Modifier,
    itemList: List<TTCurrencyItemData>,
    itemSelected: TTCurrencyItemData? = null,
    onClick: (id: Int) -> Unit,
) {
    Column(modifier = modifier) {
        itemList.forEach {
            Row(
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = { onClick(it.id) },
                    )
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(TTTheme.colorScheme.secondaryColor)
                ) {
                    AXHeaderTextVariant(
                        modifier = Modifier.align(Alignment.Center),
                        text = it.symbol,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AXHeaderText14(text = it.value)
                    it.name?.let {
                        AXBodyText18(text = Separator + it)
                    }
                }
                Box(
                    modifier = Modifier
                        .border(1.dp, TTTheme.colorScheme.primaryColor, CircleShape)
                        .clip(CircleShape)
                        .size(22.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                if (it == itemSelected) TTTheme.colorScheme.secondaryColor else TTTheme.colorScheme.background
                            )
                            .size(16.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCurrencyPickerPreview() {
    val itemList = listOf(
        TTCurrencyItemData(id = 1, value = "USD", name = "US Dollar", symbol = "$"),
        TTCurrencyItemData(id = 2, value = "EUR", name = "Euro", symbol = "€"),
        TTCurrencyItemData(id = 3, value = "JPY", name = "Japanese Yen", symbol = "¥"),
        TTCurrencyItemData(id = 4, value = "GBP", name = "British Pound", symbol = "£"),
        TTCurrencyItemData(id = 5, value = "AUD", name = "Australian Dollar", symbol = "A$")
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Example 1: Basic usage with multiple currencies and one selected
        TTCurrencyPicker(
            itemList = itemList,
            itemSelected = itemList[1],
            onClick = { currencyId -> println("Clicked on currency: $currencyId") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Example 2: No item selected

        TTCurrencyPicker(
            itemList = itemList,
            onClick = { currencyId -> println("Clicked on currency: $currencyId") }
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}