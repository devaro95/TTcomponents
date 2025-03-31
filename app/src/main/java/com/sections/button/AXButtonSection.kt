package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.AXButton
import com.components.button.model.AXButtonType
import com.sections.Section

@Composable
fun AXButtonSection() {
    Column {
        Section(title = "AXButton Normal") {
            AXButton(text = "Normal Button", onClick = {})
        }
        Section(title = "AXButton Small") {
            AXButton(text = "Small Button", buttonType = AXButtonType.SMALL, onClick = {})
        }
        Section(title = "AXButton Large") {
            AXButton(text = "Large Button", buttonType = AXButtonType.LARGE, onClick = {})
        }
        Section(title = "AXButton Disabled") {
            AXButton(text = "Disabled Button", enabled = false, onClick = {})
        }
    }
}
