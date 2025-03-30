package com.sections.picker

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.components.picker.TTListPicker
import com.components.picker.model.TTListItemData
import com.sections.Section

@Composable
fun TTListPickerSection() {
    val itemList = listOf(
        TTListItemData(id = 1, value = "Option 1"),
        TTListItemData(id = 2, value = "Option 2"),
        TTListItemData(id = 3, value = "Option 3"),
        TTListItemData(id = 4, value = "Option 4"),
        TTListItemData(id = 5, value = "Option 5")
    )
    val selectedItems = remember { mutableStateListOf<TTListItemData>(itemList[2], itemList[3]) }
    Column {
        Section(title = "TTListPicker") {
            TTListPicker(
                itemList = itemList,
                onClick = { }
            )
        }
        Section(title = "TTListPicker selected items") {
            TTListPicker(
                itemList = itemList,
                itemSelectedList = selectedItems,
                onClick = { }
            )
        }
    }
}
