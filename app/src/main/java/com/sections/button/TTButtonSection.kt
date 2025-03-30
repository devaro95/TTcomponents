package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.ButtonType
import com.components.button.TTButton
import com.sections.Section

@Composable
fun TTButtonSection() {
    Column {
        Section(title = "TTButton Normal",) {
            TTButton(text = "Normal Button", onClick = {})
        }
        Section(title = "TTButton Small") {
            TTButton(text = "Small Button", buttonType = ButtonType.SMALL, onClick = {})
        }
        Section(title = "TTButton Large") {
            TTButton(text = "Large Button", buttonType = ButtonType.LARGE, onClick = {})
        }
        Section(title = "TTButton Disabled") {
            TTButton(text = "Disabled Button", enabled = false, onClick = {})
        }
    }
}
