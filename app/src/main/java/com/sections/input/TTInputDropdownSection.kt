package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.input.AXInputDropdown
import com.components.input.AXInputDropdownItemData
import com.sections.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun AXInputDropdownSection() {
    Column {
        Section(title = "AXInputDropdown with no placeholder") {
            AXInputDropdown(
                items = listOf(
                    AXInputDropdownItemData("One"),
                    AXInputDropdownItemData("Two"),
                    AXInputDropdownItemData("Three")
                ),
                placeholder = EMPTY_STRING,
                onClick = { println("Dropdown clicked (Example 7)") }
            )
        }
        Section(title = "AXInputDropdown with placeholder") {
            AXInputDropdown(
                items = listOf(
                    AXInputDropdownItemData("Option 1"),
                    AXInputDropdownItemData("Option 2"),
                    AXInputDropdownItemData("Option 3")
                ),
                placeholder = "Select an option",
                onClick = { println("Dropdown clicked (Example 1)") }
            )
        }
        Section(title = "AXInputDropdown with value") {
            AXInputDropdown(
                items = listOf(
                    AXInputDropdownItemData("January"),
                    AXInputDropdownItemData("February"),
                    AXInputDropdownItemData("March")
                ),
                placeholder = "Month",
                selectedPosition = 0,
                onClick = { println("Dropdown clicked (Example 3)") }
            )
        }
        Section(title = "AXInputDropdown error") {
            AXInputDropdown(
                items = listOf(
                    AXInputDropdownItemData("Error 1"),
                    AXInputDropdownItemData("Error 2"),
                    AXInputDropdownItemData("Error 3")
                ),
                placeholder = "Error",
                isError = true,
                onClick = { println("Dropdown clicked (Example 5)") }
            )
        }
    }
}
