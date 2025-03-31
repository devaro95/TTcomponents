package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.input.AXInputClickableDropdown
import com.sections.Section

@Composable
fun AXInputClickableDropdownSection() {
    Column {
        Section(title = "AXInputClickableDropdown") {
            AXInputClickableDropdown(
                value = "EUR"
            )
        }
    }
}
