package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.input.TTInputClickableDropdown
import com.sections.Section

@Composable
fun TTInputClickableDropdownSection() {
    Column {
        Section(title = "TTInputClickableDropdown") {
            TTInputClickableDropdown(
                value = "EUR"
            )
        }
    }
}
