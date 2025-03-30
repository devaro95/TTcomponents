package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.input.TTInputDropdown
import com.components.input.TTInputDropdownItemData
import com.sections.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun TTInputDropdownSection() {
    Column {
        Section(title = "TTInputDropdown with no placeholder") {
            TTInputDropdown(
                items = listOf(
                    TTInputDropdownItemData("One"),
                    TTInputDropdownItemData("Two"),
                    TTInputDropdownItemData("Three")
                ),
                placeholder = EMPTY_STRING,
                onClick = { println("Dropdown clicked (Example 7)") }
            )
        }
        Section(title = "TTInputDropdown with placeholder") {
            TTInputDropdown(
                items = listOf(
                    TTInputDropdownItemData("Option 1"),
                    TTInputDropdownItemData("Option 2"),
                    TTInputDropdownItemData("Option 3")
                ),
                placeholder = "Select an option",
                onClick = { println("Dropdown clicked (Example 1)") }
            )
        }
        Section(title = "TTInputDropdown with value") {
            TTInputDropdown(
                items = listOf(
                    TTInputDropdownItemData("January"),
                    TTInputDropdownItemData("February"),
                    TTInputDropdownItemData("March")
                ),
                placeholder = "Month",
                selectedPosition = 0,
                onClick = { println("Dropdown clicked (Example 3)") }
            )
        }
        Section(title = "TTInputDropdown error") {
            TTInputDropdown(
                items = listOf(
                    TTInputDropdownItemData("Error 1"),
                    TTInputDropdownItemData("Error 2"),
                    TTInputDropdownItemData("Error 3")
                ),
                placeholder = "Error",
                isError = true,
                onClick = { println("Dropdown clicked (Example 5)") }
            )
        }
    }
}
