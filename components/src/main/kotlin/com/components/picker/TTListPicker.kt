package com.components.picker

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.components.picker.model.TTListItemData
import com.components.text.TTHeaderText14
import com.theming.TTTheme
import com.vro.compose.preview.VROLightMultiDevicePreview

/**
 * `TTListPicker` is a composable function that creates a list picker with selectable items.
 *
 * This component displays a vertically arranged list of items, where each item can be selected
 * or unselected. It provides a clear visual indication of which items are currently selected.
 *
 * @param modifier Modifier to apply to the outer `Column` containing the list.
 *                 Use this to control layout properties, such as padding, size, and alignment.
 * @param itemList A list of `TTListItemData` objects representing the items to display in the picker.
 * @param itemSelectedList A list of `TTListItemData` objects representing the currently selected items.
 * @param onClick Lambda that is invoked when an item is clicked. It provides the `id` of the clicked item.
 *
 * Example Usage:
 * @sample TTListPickerPreview
 *
 */
@Composable
fun TTListPicker(
    modifier: Modifier = Modifier,
    itemList: List<TTListItemData>,
    itemSelectedList: List<TTListItemData> = emptyList(),
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
                    .padding(vertical = 8.dp)
            ) {
                TTHeaderText14(
                    modifier = Modifier.weight(1f),
                    text = it.value
                )
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
                                if (it in itemSelectedList) TTTheme.colorScheme.secondaryColor
                                else TTTheme.colorScheme.background
                            )
                            .size(16.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
@VROLightMultiDevicePreview
fun TTListPickerPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Example 1: Basic usage with multiple selections
        val itemList = listOf(
            TTListItemData(id = 1, value = "Option 1"),
            TTListItemData(id = 2, value = "Option 2"),
            TTListItemData(id = 3, value = "Option 3"),
            TTListItemData(id = 4, value = "Option 4"),
            TTListItemData(id = 5, value = "Option 5")
        )
        val selectedItems = remember { mutableStateListOf<TTListItemData>(itemList[2], itemList[3]) }

        TTListPicker(
            itemList = itemList,
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTListPicker(
            itemList = itemList,
            itemSelectedList = selectedItems,
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TTListPicker(
            itemList = itemList,
            itemSelectedList = selectedItems,
            onClick = { }
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}