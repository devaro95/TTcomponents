package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.button.TTButtonSecondary
import com.utils.Section

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