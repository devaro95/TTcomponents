package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.TTFloatingButton
import com.sections.Section

@Composable
fun TTFloatingButtonSection() {
    Column {
        Section(title = "TTFloatingButton") {
            TTFloatingButton(text = "Example", onClick = {})
        }
        Section(title = "TTFloatingButton disabled") {
            TTFloatingButton(text = "Disabled", enabled = false, onClick = {})
        }
        Section(title = "TTFloatingButton with long text") {
            TTFloatingButton(text = "Example with long text", onClick = {})
        }
    }
}
