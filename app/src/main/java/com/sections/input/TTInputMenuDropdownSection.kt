package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.components.input.TTInputMenuDropdown
import com.components.input.TTInputMenuDropdownItemData
import com.sections.Section

@Composable
fun TTInputMenuDropdownSection() {
    val items = listOf(
        TTInputMenuDropdownItemData(0, "Option 1"),
        TTInputMenuDropdownItemData(1, "Option 2"),
        TTInputMenuDropdownItemData(2, "Option 3")
    )

    Column {
        Section(title = "TTInputDropdown with no placeholder") {
            var selectedPosition by remember { mutableStateOf<Int?>(null) }
            TTInputMenuDropdown(
                items = items,
                selectedPosition = selectedPosition,
                onItemSelected = { item ->
                    selectedPosition = items.indexOf(item)
                },
            )
        }
        Section(title = "TTInputDropdown with placeholder") {
            var selectedPosition by remember { mutableStateOf<Int?>(null) }
            TTInputMenuDropdown(
                placeholder = "Select an option",
                items = items,
                selectedPosition = selectedPosition,
                onItemSelected = { item ->
                    selectedPosition = items.indexOf(item)
                },
            )
        }
        Section(title = "TTInputDropdown with value") {
            var selectedPosition by remember { mutableIntStateOf(2) }
            TTInputMenuDropdown(
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
