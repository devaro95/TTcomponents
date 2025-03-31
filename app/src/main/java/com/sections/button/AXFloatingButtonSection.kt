package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.AXFloatingButton
import com.sections.Section

@Composable
fun AXFloatingButtonSection() {
    Column {
        Section(title = "AXFloatingButton") {
            AXFloatingButton(text = "Example", onClick = {})
        }
        Section(title = "AXFloatingButton disabled") {
            AXFloatingButton(text = "Disabled", enabled = false, onClick = {})
        }
        Section(title = "AXFloatingButton with long text") {
            AXFloatingButton(text = "Example with long text", onClick = {})
        }
    }
}
