package com.sections.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.components.input.TTInputPassword
import com.utils.Section
import com.vro.constants.EMPTY_STRING

@Composable
fun TTInputPasswordSection() {
    Column {
        Section(title = "TTInputPassword empty") {
            var passwordBasic by remember { mutableStateOf(EMPTY_STRING) }
            TTInputPassword(
                value = passwordBasic,
                onChange = { passwordBasic = it }
            )
        }
        Section(title = "TTInputPassword with placeholder") {
            var passwordBasic by remember { mutableStateOf(EMPTY_STRING) }
            TTInputPassword(
                value = passwordBasic,
                placeholder = "Basic password",
                onChange = { passwordBasic = it }
            )
        }
        Section(title = "TTInputPassword with value") {
            var passwordValue by remember { mutableStateOf("Example value") }
            TTInputPassword(
                value = passwordValue,
                placeholder = "Basic password",
                onChange = { passwordValue = it }
            )
        }
        Section(title = "TTInputPassword with error") {
            var passwordError2 by remember { mutableStateOf(EMPTY_STRING) }
            TTInputPassword(
                value = passwordError2,
                placeholder = "Password with error",
                isError = true,
                onChange = { passwordError2 = it }
            )
        }
        Section(title = "TTInputPassword with error text") {
            var passwordError by remember { mutableStateOf(EMPTY_STRING) }
            TTInputPassword(
                value = passwordError,
                placeholder = "Password with error text",
                errorText = "Invalid password format",
                isError = true,
                onChange = { passwordError = it }
            )
        }
    }
}