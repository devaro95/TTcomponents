package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.button.TTButtonSave
import com.sections.Section

@Composable
fun TTButtonSaveSection() {
    Column {
        Section(title = "TTButtonSave") {
            TTButtonSave(onClick = {})
        }
    }
}
