package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.components.input.TTInput
import com.utils.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun TTInputSection() {
    Column {
        Section(title = "TTInput with placeholder") {
            TTInput(
                value = EMPTY_STRING,
                placeholder = "Input",
                onChange = {}
            )
        }
        Section(title = "TTInput with value") {
            TTInput(
                value = "Value",
                onChange = {}
            )
        }
        Section(title = "TTInput with value and placeholder") {
            TTInput(
                value = "value",
                placeholder = "Input",
                onChange = {}
            )
        }
        Section(title = "TTInput with counter") {
            TTInput(
                value = EMPTY_STRING,
                minLength = 10,
                maxLength = 100,
                placeholder = "Counter Input",
                showCharCounter = true,
                onChange = {}
            )
        }
        Section(title = "TTInput with error") {
            TTInput(
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