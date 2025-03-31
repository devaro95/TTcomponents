package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.AXButtonSave
import com.sections.Section

@Composable
fun AXButtonSaveSection() {
    Column {
        Section(title = "AXButtonSave") {
            AXButtonSave(onClick = {})
        }
    }
}
