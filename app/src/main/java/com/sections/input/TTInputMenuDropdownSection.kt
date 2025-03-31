package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.components.input.AXInputMenuDropdown
import com.components.input.AXInputMenuDropdownItemData
import com.sections.Section

@Composable
fun AXInputMenuDropdownSection() {
    val items = listOf(
        AXInputMenuDropdownItemData(0, "Option 1"),
        AXInputMenuDropdownItemData(1, "Option 2"),
        AXInputMenuDropdownItemData(2, "Option 3")
    )

    Column {
        Section(title = "AXInputDropdown with no placeholder") {
            var selectedPosition by remember { mutableStateOf<Int?>(null) }
            AXInputMenuDropdown(
                items = items,
                selectedPosition = selectedPosition,
                onItemSelected = { item ->
                    selectedPosition = items.indexOf(item)
                },
            )
        }
        Section(title = "AXInputDropdown with placeholder") {
            var selectedPosition by remember { mutableStateOf<Int?>(null) }
            AXInputMenuDropdown(
                placeholder = "Select an option",
                items = items,
                selectedPosition = selectedPosition,
                onItemSelected = { item ->
                    selectedPosition = items.indexOf(item)
                },
            )
        }
        Section(title = "AXInputDropdown with value") {
            var selectedPosition by remember { mutableIntStateOf(2) }
            AXInputMenuDropdown(
                placeholder = "Select an option",
                items = items,
                selectedPosition = selectedPosition,
                onItemSelected = { item ->
                    selectedPosition = items.indexOf(item)
                },
            )
        }
    }
}
