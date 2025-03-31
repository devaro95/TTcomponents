package com.sections.guideSection.indicator

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.indicator.AXStepperIndicator
import com.sections.Section

@Composable
fun AXStepperIndicatorSection() {
    Column {
        Section(
            title = "AXStepperIndicatorSection"
        ) {
            AXStepperIndicator(
                items = 3,
                currentItem = 1
            )
        }
    }
}
