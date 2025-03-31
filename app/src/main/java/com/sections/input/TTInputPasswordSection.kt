package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.components.input.AXInputPassword
import com.sections.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun AXInputPasswordSection() {
    Column {
        Section(title = "AXInputPassword empty") {
            var passwordBasic by remember { mutableStateOf(EMPTY_STRING) }
            AXInputPassword(
                value = passwordBasic,
                onChange = { passwordBasic = it }
            )
        }
        Section(title = "AXInputPassword with placeholder") {
            var passwordBasic by remember { mutableStateOf(EMPTY_STRING) }
            AXInputPassword(
                value = passwordBasic,
                placeholder = "Basic password",
                onChange = { passwordBasic = it }
            )
        }
        Section(title = "AXInputPassword with value") {
            var passwordValue by remember { mutableStateOf("Example value") }
            AXInputPassword(
                value = passwordValue,
                placeholder = "Basic password",
                onChange = { passwordValue = it }
            )
        }
        Section(title = "AXInputPassword with error") {
            var passwordError2 by remember { mutableStateOf(EMPTY_STRING) }
            AXInputPassword(
                value = passwordError2,
                placeholder = "Password with error",
                isError = true,
                onChange = { passwordError2 = it }
            )
        }
        Section(title = "AXInputPassword with error text") {
            var passwordError by remember { mutableStateOf(EMPTY_STRING) }
            AXInputPassword(
                value = passwordError,
                placeholder = "Password with error text",
                errorText = "Invalid password format",
                isError = true,
                onChange = { passwordError = it }
            )
        }
    }
}
