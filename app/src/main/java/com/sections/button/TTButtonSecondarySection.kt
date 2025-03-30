package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.TTButtonSecondary
import com.sections.Section

@Composable
fun TTButtonSecondarySection() {
    Column {
        Section(title = "TTButtonSecondary") {
            TTButtonSecondary(text = "Example", onClick = {})
        }
        Section(title = "TTButtonSecondary disabled") {
            TTButtonSecondary(text = "Disabled", enabled = false, onClick = {})
        }
        Section(title = "TTButtonSecondary with long text") {
            TTButtonSecondary(text = "Example with long text", onClick = {})
        }
    }
}
