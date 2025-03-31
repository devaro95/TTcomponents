package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.AXButtonSecondary
import com.sections.Section

@Composable
fun AXButtonSecondarySection() {
    Column {
        Section(title = "AXButtonSecondary") {
            AXButtonSecondary(text = "Example", onClick = {})
        }
        Section(title = "AXButtonSecondary disabled") {
            AXButtonSecondary(text = "Disabled", enabled = false, onClick = {})
        }
        Section(title = "AXButtonSecondary with long text") {
            AXButtonSecondary(text = "Example with long text", onClick = {})
        }
    }
}
