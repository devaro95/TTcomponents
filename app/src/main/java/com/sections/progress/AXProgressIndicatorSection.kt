package com.sections.progress

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.indicator.AXProgressIndicator
import com.sections.Section

@Composable
fun AXProgressBarSection() {
    Column {
        Section(title = "AXProgressIndicator empty") {
            AXProgressIndicator(
                duration = 4000,
                progress = 0f
            )
        }
        Section(title = "AXProgressIndicator custom progress") {
            AXProgressIndicator(
                duration = 1000,
                progress = 0.5f
            )
        }
        Section(title = "AXProgressIndicator full progress") {
            AXProgressIndicator(
                duration = 1000,
                progress = 1f
            )
        }
    }
}
