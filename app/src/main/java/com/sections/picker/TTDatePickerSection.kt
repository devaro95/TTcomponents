package com.sections.picker

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.components.button.TTButton
import com.components.picker.TTDatePicker
import com.sections.Section
import java.util.Date

@Composable
fun TTDatePickerSection() {
    var showDatePicker1 by remember { mutableStateOf(false) }
    var showDatePicker2 by remember { mutableStateOf(false) }
    var showDatePicker3 by remember { mutableStateOf(false) }
    Column {
        Section(title = "TTDatePicker basic") {
            TTButton(text = "Click to show") { showDatePicker1 = true }
            if (showDatePicker1) {
                TTDatePicker(
                    title = "Select a Date",
                    onConfirm = { showDatePicker1 = false },
                    onCancel = { showDatePicker1 = false }
                )
            }
        }
        Section(title = "TTDatePicker start selectable date") {
            TTButton(text = "Click to show") { showDatePicker2 = true }
            if (showDatePicker2) {
                TTDatePicker(
                    title = "Select a Date",
                    startSelectableDate = Date().time + (1000 * 60 * 60 * 24 * 3),
                    onConfirm = { showDatePicker2 = false },
                    onCancel = { showDatePicker2 = false }
                )

            }
        }
        Section(title = "TTDatePicker selected date") {
            TTButton(text = "Click to show") { showDatePicker3 = true }
            if (showDatePicker3) {
                TTDatePicker(
                    selectedDate = Date().time + (1000 * 60 * 60 * 24 * 15),
                    title = "Select a Date",
                    onConfirm = { showDatePicker3 = false },
                    onCancel = { showDatePicker3 = false }
                )
            }
        }
    }
}
