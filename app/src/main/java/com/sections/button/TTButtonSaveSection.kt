package com.sections.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.button.TTButtonSave
import com.utils.Section

@Composable
fun TTButtonSaveSection() {
    Column {
        Section(title = "TTButtonSave") {
            TTButtonSave(onClick = {})
        }
    }
}