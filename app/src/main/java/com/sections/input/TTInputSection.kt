package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.input.AXInput
import com.sections.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun AXInputSection() {
    Column {
        Section(title = "AXInput with placeholder") {
            AXInput(
                value = EMPTY_STRING,
                placeholder = "Input",
                onChange = {}
            )
        }
        Section(title = "AXInput with value") {
            AXInput(
                value = "Value",
                onChange = {}
            )
        }
        Section(title = "AXInput with value and placeholder") {
            AXInput(
                value = "value",
                placeholder = "Input",
                onChange = {}
            )
        }
        Section(title = "AXInput with counter") {
            AXInput(
                value = EMPTY_STRING,
                minLength = 10,
                maxLength = 100,
                placeholder = "Counter Input",
                showCharCounter = true,
                onChange = {}
            )
        }
        Section(title = "AXInput with error") {
            AXInput(
                value = EMPTY_STRING,
                minLength = 10,
                maxLength = 100,
                placeholder = "Counter Input",
                onChange = {},
                isError = true,
                errorText = "Error"
            )
        }
    }
}
