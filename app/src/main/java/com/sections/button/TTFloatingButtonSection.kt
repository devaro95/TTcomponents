package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.button.TTFloatingButton
import com.utils.Section

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